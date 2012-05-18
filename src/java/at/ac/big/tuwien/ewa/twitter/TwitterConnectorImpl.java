/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.big.tuwien.ewa.twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author bernhard
 */
public class TwitterConnectorImpl implements TwitterConnector {

    @Override
    public Status postMessage(Score score) throws TwitterException {
        // Given a Score object, post to Twitter
        
        Twitter twitter = new TwitterFactory().getInstance();
        Status status = twitter.updateStatus(score.getTwitterPublicationString());
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        return status;
    }
    
}
