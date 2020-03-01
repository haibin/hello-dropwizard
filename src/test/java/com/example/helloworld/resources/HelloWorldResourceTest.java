package com.example.helloworld.resources;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import com.example.helloworld.HelloWorldApplication;
import com.example.helloworld.HelloWorldConfiguration;

import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

public class HelloWorldResourceTest {

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE =
            new DropwizardAppRule<>(HelloWorldApplication.class, ResourceHelpers.resourceFilePath("config.yml"));

    @Test
    public void helloWorld() {
        Client client = RULE.client();

        Response response = client.target(
                 String.format("http://localhost:%d/hello-world", RULE.getLocalPort()))
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }    
}