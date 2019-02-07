package org.lithium.Resources;

import com.codahale.metrics.annotation.Timed;
import org.eclipse.jetty.util.log.Slf4jLog;
import org.lithium.Response;
import org.lithium.Services.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(Slf4jLog.class);
    public  TwitterTimelineResource(Twitter twitter) {
        this.twitter = twitter;
    }
    @GET
    @Timed
    public Response getTimeline() {
        logger.info("Getting timeline");
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);
        try {
            List<Status> statuses = TwitterService.getInstance().getTimeLine(twitter);
            result.setTweets(statuses);
            result.setSuccess(Boolean.TRUE);
            logger.info("Got timeline.");
        } catch (TwitterException e) {
            logger.error(e.getMessage(), e);
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }
}
