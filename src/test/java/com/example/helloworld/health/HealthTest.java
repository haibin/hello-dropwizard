package com.example.helloworld.health;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import com.example.helloworld.HelloWorldApplication;
import com.example.helloworld.HelloWorldConfiguration;
import com.squarespace.jersey2.guice.JerseyGuiceUtils;

import org.junit.AfterClass;
import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

public class HealthTest {

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE =
            new DropwizardAppRule<>(HelloWorldApplication.class, ResourceHelpers.resourceFilePath("config.yml"));

    @AfterClass
    public static void tearDown() {
        // https://github.com/HubSpot/dropwizard-guice#testing
        JerseyGuiceUtils.reset();
    }

    @Test
    public void healthCheck() {
        Client client = RULE.client();

        Response response = client.target(
                 String.format("http://localhost:%d/healthcheck", RULE.getAdminPort()))
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }
}