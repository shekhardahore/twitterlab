package org.lithium.Resources;

import com.codahale.metrics.annotation.Timed;
import org.eclipse.jetty.util.log.Slf4jLog;
import org.lithium.Response;
import org.lithium.Services.TwitterService;
import org.lithium.Tweet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(Slf4jLog.class);
    public  TwitterPublishResource(Twitter twitter) {
        this.twitter = twitter;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response tweetMessage(Tweet tweet) {
        logger.info("Publishing tweet: " + tweet);
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);
        try {
            Status status = TwitterService.getInstance().postTweet(twitter, tweet.getMessage());
            result.setMessage("Successfully updated the status to [" + status.getText() + "].");
            result.setSuccess(Boolean.TRUE);
            logger.info("Publishing successful");
        } catch (TwitterException e) {
            logger.error(e.getMessage(), e);
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }
}
