package org.lithium;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterOne {
    void publishTweet(String tweet) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
}
