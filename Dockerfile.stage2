FROM eclipse-temurin:17.0.8_7-jdk-alpine
#COPY --from=builder /target/spring-app-0.0.1-SNAPSHOT.jar /app
#COPY --from=builder /application.properties /app
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "spring-app-0.0.1-SNAPSHOT.jar"]
ARG JAR_FILE=target/spring-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]