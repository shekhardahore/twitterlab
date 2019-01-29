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
    public  TwitterTimelineResource() {

    }
    @GET
    @Timed
    public Response getTimeline() {
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);

        Twitter twitter = TwitterFactory.getSingleton();
        try {
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" +
                        status.getText());
            }
            result.setMessage("Successfully updated the status.");
            result.setSuccess(Boolean.TRUE);
        } catch (TwitterException e) {
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }
}
