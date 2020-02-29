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