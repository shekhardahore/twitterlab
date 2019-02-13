package org.lithium.Services;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public class TwitterService {

    public List<Status> getTimeLine(Twitter twitter) throws TwitterException {
        List<Status> statuses = twitter.getHomeTimeline();
        return  statuses;
    }

    public Status postTweet(Twitter twitter, String tweet) throws  TwitterException {
        Status status = twitter.updateStatus(tweet);
        return status;
    }
}
