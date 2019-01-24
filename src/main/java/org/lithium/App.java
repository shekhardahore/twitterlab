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
        // nothing to do yet
    }

    @Override
    public void run(TwitterConfiguration configuration,
                    Environment environment) {
        // nothing to do yet
        final TwitterLabResource resource = new TwitterLabResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}