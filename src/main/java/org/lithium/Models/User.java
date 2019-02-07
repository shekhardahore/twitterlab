package org.lithium.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String twitterHandle;
    private String name;
    private String profileImageUrl;

    @JsonProperty
    public String getTwitterHandle() {
        return twitterHandle;
    }

    @JsonProperty
    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    @JsonProperty
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
