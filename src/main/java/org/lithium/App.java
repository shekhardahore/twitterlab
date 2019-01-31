package org.lithium;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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

        final TwitterPublishResource publishResource = new TwitterPublishResource();
        environment.jersey().register(publishResource);
        final TwitterTimelineResource timelineResource = new TwitterTimelineResource();
        environment.jersey().register(timelineResource);

    }
}