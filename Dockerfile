FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ADD build/libs/*.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]