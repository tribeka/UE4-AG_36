package at.ac.big.tuwien.ewa.twitter;

import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * Provides the necessary interfaces for the twitter connector
 * @author pl
 *
 */
public interface TwitterConnector {
	
	
	
	
	/** Used to post a message on twitter */
	public Status postMessage(Score score) throws TwitterException;
	
	

}
