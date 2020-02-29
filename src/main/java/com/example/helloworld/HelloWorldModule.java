package com.example.helloworld;

import com.example.helloworld.db.RedisDao;
import com.example.helloworld.db.RedisDaoImpl;
import com.google.inject.AbstractModule;

public class HelloWorldModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RedisDao.class).to(RedisDaoImpl.class);
    }
}