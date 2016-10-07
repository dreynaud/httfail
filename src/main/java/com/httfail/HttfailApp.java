package com.httfail;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HttfailApp extends Application<HttfailConfiguration> {
    public static void main(String[] args) throws Exception {
        new HttfailApp().run(args);
    }

    @Override
    public String getName() {
        return "httfail";
    }

    @Override
    public void initialize(Bootstrap<HttfailConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HttfailConfiguration configuration, Environment environment) {
        final HttfailResource resource = new HttfailResource(
                configuration.getDefaultStatus(),
                configuration.getDefaultReason()
        );
        environment.jersey().register(resource);
        environment.healthChecks().register("httpfail-happy", new HttfailHealthcheck());
    }
}