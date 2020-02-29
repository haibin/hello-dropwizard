https://travis-ci.com/haibin/hello-dropwizard.svg?branch=master

# hello-dropwizard

Use `java-simple` to create the project skeleton. Note that I'm using version 1.3.9, not the latest 2.0.0. Because I want to use `dropwizard-guice` which does not seem to work with the latest version of dropwizard.

```
$ mvn -B archetype:generate \
    -DarchetypeGroupId=io.dropwizard.archetypes \
    -DarchetypeArtifactId=java-simple \
    -DarchetypeVersion=1.3.9 \
    -DgroupId=com.example.helloworld \
    -DartifactId=hello-dropwizard \
    -Dversion=1.0-SNAPSHOT \
    -Dname=HelloWorld
```

Build the application and run it.

```
$ mvn package
$ java -jar target/hello-dropwizard-1.0-SNAPSHOT.jar server config.yml
```

Hit the endpoint.

```
$ curl http://localhost:8080            
{"code":404,"message":"HTTP 404 Not Found"}
$ curl http://localhost:8081/healthcheck                     
{"deadlocks":{"healthy":true}}
```

## Docker

```
$ docker build -t hello-dropwizard:1.0 .
$ docker run --rm -p 8080:8080 -p 8081:8081 hello-dropwizard:1.0
```
