package org.lithium.Resources;

import com.codahale.metrics.annotation.Timed;
import org.eclipse.jetty.util.log.Slf4jLog;
import org.lithium.Models.Response;
import org.lithium.Services.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/api/1.0/tweet/filter")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterFilterResource {
    private Twitter twitter;
    private static Logger logger = LoggerFactory.getLogger(Slf4jLog.class);
    public  TwitterFilterResource(Twitter twitter) {
        this.twitter = twitter;
    }
    @GET
    @Timed
    public Response getFilteredTweets(@QueryParam("filter") Optional<String> filterString) {
        logger.info("Getting Filtered tweets");
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);
        try {
            List<Status> statuses = TwitterService.getInstance().getTimeLine(twitter);
            final List<Status> statusStream = statuses.stream().filter(str -> str.getText().contains(filterString.get())).collect(Collectors.toList());
            result.setTweets(statusStream);
            result.setSuccess(Boolean.TRUE);
            logger.info("Got  Filtered tweets.");
        } catch (TwitterException e) {
            logger.error("Failed to get filtered tweets.");
            logger.error(e.getMessage(), e);
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }
}
