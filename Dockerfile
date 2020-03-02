FROM maven:3.6.3-jdk-11-openj9

WORKDIR /app
COPY src /app
COPY pom.xml /app
COPY config.yml /app

RUN mvn clean package

CMD ["java", "-jar", "target/hello-dropwizard-1.0-SNAPSHOT.jar", "server", "config.yml"]
