package org.lithium.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {
    private String message;
    private Double createdAt;
    /**
     * @return the message
     */
    @JsonProperty
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }
}
