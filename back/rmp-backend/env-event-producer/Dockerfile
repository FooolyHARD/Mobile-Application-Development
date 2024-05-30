FROM openjdk:17
WORKDIR /
COPY build/libs/env-event-producer-all.jar .
EXPOSE 13001
CMD ["java", "-jar", "env-event-producer-all.jar"]