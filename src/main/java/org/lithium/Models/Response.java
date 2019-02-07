package org.lithium.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private String guid = null;
    private Boolean success = false;
    private String message = null;
    private List<TweetModel> tweets;

    public Response() {

    }

    @JsonProperty
    public  List<TweetModel> getTweets() { return tweets; }

    public void  setTweets(List<Status> tweets) {
        List<TweetModel> tweetList = new ArrayList<>();

        for (Status temp : tweets)  {
            TweetModel tweet = new TweetModel();
            tweet.setMessage(temp.getText());
            tweet.setCreatedAt(temp.getCreatedAt());
            tweet.setUser(temp.getUser());
            tweetList.add(tweet);
        }
        this.tweets = tweetList;
    }

    @JsonProperty
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}