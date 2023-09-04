#FROM maven:3.6.3-openjdk-17 AS builder
#COPY src /
#COPY pom.xml /
#COPY src/main/resources/application.properties /
#RUN mvn package spring-boot:repackage

FROM eclipse-temurin:17.0.8_7-jdk-alpine
WORKDIR /app
COPY --from=builder /target/spring-app-0.0.1-SNAPSHOT.jar /app
COPY --from=builder /application.properties /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-app-0.0.1-SNAPSHOT.jar"]



