package org.lithium;
import twitter4j.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws  TwitterException
    {
        TwitterOne twitterOne = new TwitterOne();
        twitterOne.publishTweet("This is a test.");
        TwitterTwo twitterPull = new TwitterTwo();
        twitterPull.getTimeline();
    }
}
