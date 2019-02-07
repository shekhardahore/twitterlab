package org.lithium;

import com.codahale.metrics.annotation.Timed;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;


@Path("/timeline")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterTimelineResource {
    private Twitter twitter;
    public  TwitterTimelineResource(Twitter twitter) {
        this.twitter = twitter;
    }
    @GET
    @Timed
    public Response getTimeline() {
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);
        try {
            List<Status> statuses = twitter.getHomeTimeline();
            result.setTweets(statuses);
            result.setSuccess(Boolean.TRUE);
        } catch (TwitterException e) {
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }
}
