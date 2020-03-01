# FROM adoptopenjdk:11-jre-hotspot
FROM maven:3.6-jdk-11-slim

WORKDIR /app
COPY src /app
COPY pom.xml /app
COPY Dockerfile /app
COPY docker-compose.yml /app

