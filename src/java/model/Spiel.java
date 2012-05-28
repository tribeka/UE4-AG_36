package model;

import at.ac.big.tuwien.ewa.twitter.Score;
import at.ac.big.tuwien.ewa.twitter.TwitterConnector;
import at.ac.big.tuwien.ewa.twitter.TwitterConnectorImpl;
import controller.LoginCtrl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.beans.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import publishservice.*;
import publishservice.InfoType.Players;
import publishservice.InfoType.Players.Screenname;
import publishservice.InfoType.Winner;
import twitter4j.Status;
import twitter4j.TwitterException;

@ManagedBean(name = "mygame")
@SessionScoped
public class Spiel implements Serializable {
    private List<Spieler> Players;
    private Spielfeld Playarea;
    public HashMap<Spieler, LinkedList<Integer>> LastDies;

    private Integer Round;
    private long Starttime;
    private Boolean Over;
    
    private Spieler WinPlayer;
    private String GUID;

    @ManagedProperty(value = "#{login}")
    private LoginCtrl login;

    private Spieler humanplayer;

    public Spiel() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        this.login = (LoginCtrl) context.getApplication().evaluateExpressionGet(context, "#{login}", LoginCtrl.class);

        Spieler player = login.getPlayer();

        if (player == null)
            player = new Spieler("Gast");

        this.humanplayer = player;

        Players = Arrays.asList(this.humanplayer, new Spieler("Computer"));

        LastDies = new HashMap<Spieler, LinkedList<Integer>>();

        for (Spieler s : Players)
            LastDies.put(s, new LinkedList<Integer>());


        this.reset();
    }

    public Spiel(Spieler player) {
        Players = Arrays.asList(player, new Spieler("Computer"));

        LastDies = new HashMap<Spieler, LinkedList<Integer>>();

        for (Spieler s : Players)
            LastDies.put(s, new LinkedList<Integer>());


        this.reset();
    }

    public final String reset() {
        Playarea = new SpielfeldImpl(Players);
        Round = 0;
        Over = false;
        WinPlayer = null;
        GUID = "";
        Starttime = new Date().getTime();
        for (Spieler s : Players)
            LastDies.get(s).clear();
        return "/table.xhtml";
    }

    public Boolean getOver() {
        return Over;
    }

    public Spieler getLeader() {

        Integer dist = Integer.MAX_VALUE;

        if (Over) {
            for (Spieler s : Players)
                if (Playarea.isPlayerFinished(s))
                    return s;
        }

        Spieler leader = Players.get(0);
        for (Spieler s : Players) {
            Integer sdist = Playarea.distanceToFinish(s);
            if (sdist < dist) {
                dist = sdist;
                leader = s;
            }
        }
        return leader;
    }

    public List<Spieler> getPlayer() {
        return Players;
    }

    public Spieler getHumanPlayer() {
        return Players.get(0);
    }

    public int getPlayersCnt() {
        return Players.size();
    }

    public String getTime() {
        long time = new Date().getTime();
        time = time - Starttime;
        return (time / (1000 * 60)) + " min " + ((time / 1000) % 60) + " sec";
    }

    public int getRound() {
        return Round;
    }

    public String doRound() throws DatatypeConfigurationException {
        if (Over) {
            return "";
        }
        Spieler humanPlayer = Players.get(0);
        Spieler computerPlayer = Players.get(1);

        for (Spieler s : Players)
            LastDies.get(s).clear();

        // wuerfeln
        int wurf = wuerfle();

        // spielzug
        this.spielzug(humanPlayer, wurf);
        LastDies.get(humanPlayer).offer(wurf);

        // if wuerfel == 6, zurueck zur view, da Spieler nochmals an der Reihe ist
        if ((wurf != 6) && (!Over)) {
            do {
                // Computer player - getWuerfel
                wurf = wuerfle();

                // spielzug Computer
                this.spielzug(computerPlayer, wurf);

                // if wuerfel == 6, nochmals
                LastDies.get(computerPlayer).offer(wurf);
            } while ((wurf == 6) && (!Over));

            // neue Runde - zurueck zur view
            Round++;
        }
        
        // if over -> publish to scoreboard
        if(Over) {
            Game game = new Game();
            
            InfoType info = new InfoType();
            info.setName("Gruppe 36 Game");
            
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTimeInMillis(Starttime);
            info.setStarted(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
            info.setRounds(BigInteger.valueOf((long)Round));
            
            Winner winner = new Winner();
            winner.setPlayer(Players.indexOf(WinPlayer) + 1);
            info.setWinner(winner);
            
            Players plrs = new Players();
            plrs.setNumber(Players.size());
            List<Screenname> scrname = plrs.getScreenname();
            for(Spieler p : Players) {
                Screenname sname = new Screenname();
                sname.setPlayer(Players.indexOf(p) + 1);
                sname.setValue(p.getName());
                scrname.add(sname);
            }
            info.setPlayers(plrs);
            
            game.setInfo(info);
            
            HighScoreRequestType req = new HighScoreRequestType();
            req.setUserKey("G8N4P3E5D2S8Y4X2V9M5N");
            req.setGame(game);
            
            try {
                PublishHighScoreService service = new PublishHighScoreService();
                PublishHighScoreEndpoint endpoint = service.getPublishHighScorePort();
                GUID = endpoint.publishHighScore(req);
                Logger.getLogger(Spiel.class.getName()).log(Level.INFO, "GUID: " + GUID);
                
            } catch(Exception ex) {
                Logger.getLogger(Spiel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Publish to Twitter
            Score twitterScore = new Score(GUID, WinPlayer.getName());
            TwitterConnector twitterCon = new TwitterConnectorImpl();
            try {
                Status status = twitterCon.postMessage(twitterScore);
                // Send statusmessage to user
                ResourceBundle b = ResourceBundle.getBundle("i18n", 
                    FacesContext.getCurrentInstance().getViewRoot().getLocale());
                String msgText = "UUID " + GUID + " " + b.getString("twittermsg");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, msgText, null);
                FacesContext.getCurrentInstance().addMessage("Twitter:", msg);
            } catch (TwitterException ex) {
                Logger.getLogger(Spiel.class.getName()).log(Level.SEVERE, null, ex);
                // Exception Handling - eigene Statusmessage
                ResourceBundle b = ResourceBundle.getBundle("i18n", 
                    FacesContext.getCurrentInstance().getViewRoot().getLocale());
                String msgText = b.getString("twittererror");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, msgText, null);
                FacesContext.getCurrentInstance().addMessage("Twitter:", msg);
            }
        }

        
        return "";
    }

    protected int wuerfle() {
        double zufall;
        zufall = Math.random();
        zufall = zufall * 6 + 0.5;
        return (int) Math.round(zufall);
    }

    protected void spielzug(Spieler player, int wurf) {

        // Spielstart pruefen:
        if (this.Playarea.isPlayerInStart(player)) {
            if (wurf != 6) {
                return;
            }
        }

        Feld newField = this.Playarea.getNewField(player, wurf);

        // Gegner geschlagen?
        if (newField.getContent() != null) {
            // Set the other player on a start field
            this.Playarea.resetPlayer(newField.getContent());
        }

        // Spielzug durchfuehren
        this.Playarea.setPlayerToField(player, newField);

        // gewonnen?
        if (this.Playarea.isPlayerFinished(player)) {
            this.Over = true;
            this.WinPlayer = player;
        }
    }

    public Spielfeld getPlayarea() {
        return Playarea;
    }

    public String getPlayer1DiceRolls() throws Exception {
        if (Players.size() < 1)
            throw new Exception("Invalid player");

        Spieler s = Players.get(0);
        Integer i = 0;
        if (!LastDies.get(s).isEmpty()) {
            i = LastDies.get(s).getLast();
        }

        return i.toString();
    }

    public List<Integer> getPlayer2DiceRolls() throws Exception {
        if (Players.size() < 2)
            throw new Exception("Invalid player");

        Spieler s = Players.get(1);

        return LastDies.get(s);
    }

    public String getDestroy() {
        FacesContext f = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) f.getExternalContext().getSession(false);
        session.invalidate();
        return "login.xhtml";
    }

    /**
     * @return the humanplayer
     */
    public Spieler getHumanplayer() {
        return humanplayer;
    }

    /**
     * @param humanplayer the humanplayer to set
     */
    public void setHumanplayer(Spieler humanplayer) {
        this.humanplayer = humanplayer;
    }

    /**
     * @return the login
     */
    public LoginCtrl getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(LoginCtrl login) {
        this.login = login;
    }

}
