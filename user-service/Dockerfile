FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
EXPOSE 8092
ARG JAR_FILE=build/libs/*.jar
VOLUME /tmp
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
