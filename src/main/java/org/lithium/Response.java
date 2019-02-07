package org.lithium;

import com.fasterxml.jackson.annotation.JsonProperty;
import twitter4j.Status;

import java.util.List;

public class Response {
    private String guid = null;
    private Boolean success = false;
    private String message = null;
    private List<Status> tweets;

    public Response() {

    }

    @JsonProperty
    public  List<Status> getTweets() { return tweets; }

    public void  setTweets(List<Status> tweets) { this.tweets = tweets; }

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