package org.lithium;

import com.codahale.metrics.annotation.Timed;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/publishTweet")
public class TwitterPublishResource {

    private Twitter twitter;
    public  TwitterPublishResource(Twitter twitter) {
        this.twitter = twitter;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response tweetMessage(Tweet tweet) {
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);
        try {
            Status status = twitter.updateStatus(tweet.getMessage());
            result.setMessage("Successfully updated the status to [" + status.getText() + "].");
            result.setSuccess(Boolean.TRUE);
        } catch (TwitterException e) {
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }
}
