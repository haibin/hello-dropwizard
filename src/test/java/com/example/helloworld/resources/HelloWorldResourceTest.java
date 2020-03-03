package com.example.helloworld.resources;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import com.example.helloworld.api.Saying;
import com.example.helloworld.db.RedisDao;

public class HelloWorldResourceTest {

    private static final RedisDao dao = mock(RedisDao.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
        .addResource(new HelloWorldResource(dao))
        .build();

    @Before
    public void setup() {
        when(dao.getData(eq("hello"))).thenReturn("world");
    }

    @After
    public void tearDown(){
        // we have to reset the mock after each test because of the
        // @ClassRule, or use a @Rule as mentioned below.
        reset(dao);
    }

    @Test
    public void testSayHello() {
        Saying saying = resources.target("/hello-world")
            .queryParam("name", "hello")
            .request()
            .get(Saying.class);
        assertThat(saying.getContent()).isEqualTo("world");
    }
}
