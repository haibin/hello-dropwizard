package com.example.helloworld.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.api.Saying;
import com.example.helloworld.db.RedisDao;
import com.google.inject.Inject;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final AtomicLong counter = new AtomicLong();

    private RedisDao redisDao;

    @Inject
    public HelloWorldResource(RedisDao redisDao) {
        this.redisDao = redisDao;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        String val = redisDao.getData(name.orElse(""));
        return new Saying(counter.incrementAndGet(), val);
    }
}