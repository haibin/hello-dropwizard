package com.example.helloworld;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String redisHost;

    @NotEmpty
    private String redisPort;

    @JsonProperty
    public String getRedisHost() {
        return redisHost;
    }

    @JsonProperty
    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    @JsonProperty
    public String getRedisPort() {
        return redisPort;
    }

    @JsonProperty
    public void setRedisPort(String redisPort) {
        this.redisPort = redisPort;
    }
}
