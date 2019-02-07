package org.lithium.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TweetModel {
    private String message;
    private Date createdAt;
    private User user;

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public Date getCreatedAt() { return createdAt; }

    @JsonProperty
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }


    @JsonProperty
    public User getUser() { return user; }

    public void setUser(twitter4j.User twitterUser) {
        User user = new User();
        user.setName(twitterUser.getName());
        user.setTwitterHandle(twitterUser.getScreenName());
        user.setProfileImageUrl(twitterUser.getProfileImageURL());
        this.user = user;
    }

}
