FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=board.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]