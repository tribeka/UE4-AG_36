package model;

import java.beans.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;


public interface Spielfeld extends Serializable {

    //Gibt das Feld zurück, welches der Spieler erreicht, wenn er distance (>= 1) weiterzieht.
    //Erreicht der Spieler ein Zielfeld, wird das erste erreichte Zielfeld ausgegeben.
    //Befindet sich der Spieler in der Startzone, wird das erste Feld der jeweiligen Farbe zurueckgegeben
    // Ist distance < 1, wird das aktuelle Feld der Figur zurueckgegeben.
    public Feld getNewField(Spieler player, Integer distance);

    //Setzt die Spielfigur auf das angegebene Feld.
    //Ist das angegebene Feld bereits besetzt, wird eine IllegalArgumentException geworfen.
    public void setPlayerToField(Spieler player, Feld field);

    //Setzt die Spielfigur zurueck auf das Startfeld der jeweiligen Farbe.
    public void resetPlayer(Spieler player);

    //Gibt an, wie oft die Figur noch weiterziehen muss, um ihr Zielfeld zu erreichen.
    public Integer distanceToFinish(Spieler player);

    //Gibt an, ob die Figur gerade im startfeld steht.
    public Boolean isPlayerInStart(Spieler player);

    //Gibt an, ob die Figur ein Zielfeld erreicht hat.
    public Boolean isPlayerFinished(Spieler player);


    public List<Feld> getPlayFields();


    public List<Feld> getPlayer1StartFields();

    public List<Feld> getPlayer2StartFields();

    public List<Feld> getPlayer3StartFields();

    public List<Feld> getPlayer4StartFields();


    public List<Feld> getPlayer1FinishFields();

    public List<Feld> getPlayer2FinishFields();

    public List<Feld> getPlayer3FinishFields();

    public List<Feld> getPlayer4FinishFields();
}
