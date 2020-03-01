package com.example.helloworld.db;

import com.example.helloworld.HelloWorldConfiguration;
import com.google.inject.Inject;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisDaoImpl implements RedisDao {
    private HelloWorldConfiguration config;

    @Inject
    public RedisDaoImpl(HelloWorldConfiguration config) {
        this.config = config;
    }

    @Override
    public String getData(String key) {
        String uri = String.format("redis://@%s:%s/0", config.getRedisHost(), config.getRedisPort());
        RedisClient redisClient = RedisClient.create(uri);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();
        
        String val = syncCommands.get(key);
        
        connection.close();
        redisClient.shutdown();
        
        return val;
    }
}