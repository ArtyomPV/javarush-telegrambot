FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
ENV BOT_TOKEN=1375780501:AAE4A6Rz0BSnIGzeu896OjQnjzsMEG6_uso
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]