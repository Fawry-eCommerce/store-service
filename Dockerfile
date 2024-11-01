FROM openjdk:17-jdk-alpine

LABEL authors="youso"

WORKDIR /app

COPY target/store-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8005

ENTRYPOINT ["java", "-jar", "app.jar"]