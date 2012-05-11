package at.ac.big.tuwien.ewa.twitter;


/**
 * Used to publish a score on twitter
 * @author pl
 *
 */
public class Score {
	
	private String uuid;
	private String playerName;
	
	
	public Score (String uuid, String playerName) {
		this.uuid = uuid;
		this.playerName = playerName;
	}
	
	public Score() {
		
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTwitterPublicationString() {
		return this.playerName + " highscore result UUID " + uuid;		
	}

	
	
}
