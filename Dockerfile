FROM adoptopenjdk:11-jre-hotspot

ADD target/hello-dropwizard-1.0-SNAPSHOT.jar hello-dropwizard-1.0-SNAPSHOT.jar
ADD config.yml config.yml
ENTRYPOINT ["java","-jar","hello-dropwizard-1.0-SNAPSHOT.jar","server", "config.yml"]
