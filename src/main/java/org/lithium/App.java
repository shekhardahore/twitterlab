package org.lithium;
import io.dropwizard.assets.AssetsBundle;
import org.lithium.Resources.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.util.log.Slf4jLog;
import org.lithium.Resources.TwitterTimelineResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class App extends Application<TwitterConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<TwitterConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html", "static"));
    }

    @Override
    public void run(TwitterConfiguration configuration,
                    Environment environment) {
        Logger logger = LoggerFactory.getLogger(Slf4jLog.class);
        logger.info("Server Started");
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(configuration.getConsumerKey())
                .setOAuthConsumerSecret(configuration.getConsumerSecret())
                .setOAuthAccessToken(configuration.getAccessToken())
                .setOAuthAccessTokenSecret(configuration.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        final TwitterPublishResource publishResource = new TwitterPublishResource(twitter);
        environment.jersey().register(publishResource);
        final TwitterTimelineResource timelineResource = new TwitterTimelineResource(twitter);
        environment.jersey().register(timelineResource);
        final TwitterFilterResource filterResource = new TwitterFilterResource(twitter);
        environment.jersey().register(filterResource);
    }
}
