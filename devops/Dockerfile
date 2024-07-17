FROM openjdk:17.0.2-slim

COPY ./build/libs/*.jar ./stalkConfig.jar

ARG ENCRYPT_PASSWORD

ENV ENCRYPT_PASSWORD=$ENCRYPT_PASSWORD

ENTRYPOINT ["java", "-jar", "./stalkConfig.jar"]
