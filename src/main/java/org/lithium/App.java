package org.lithium;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
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
    }

    @Override
    public void run(TwitterConfiguration configuration,
                    Environment environment) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(configuration.getConsumerKey())
                .setOAuthConsumerSecret(configuration.getConsumerSecret())
                .setOAuthAccessToken(configuration.getAccessToken())
                .setOAuthAccessTokenSecret(configuration.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        final TwitterPublishResource publishResource = new TwitterPublishResource();
        environment.jersey().register(publishResource);
        final TwitterTimelineResource timelineResource = new TwitterTimelineResource();
        environment.jersey().register(timelineResource);

    }
}