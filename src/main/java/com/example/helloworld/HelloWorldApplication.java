package com.example.helloworld;

import com.hubspot.dropwizard.guice.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private GuiceBundle<HelloWorldConfiguration> guiceBundle;

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloWorld";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.<HelloWorldConfiguration>newBuilder()
            .addModule(new HelloWorldModule())
            .enableAutoConfig(getClass().getPackage().getName())
            .setConfigClass(HelloWorldConfiguration.class)
            .build();
  
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(final HelloWorldConfiguration configuration, final Environment environment) {
        // now you don't need to add resources, tasks, healthchecks or providers
        // you must have your health checks inherit from InjectableHealthCheck in order for them to be injected
    }

}
