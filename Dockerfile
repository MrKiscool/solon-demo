FROM docker.planning.com/docker.io/eclipse-temurin:8-jdk


WORKDIR application

COPY ./target/demo.jar application.jar



ENTRYPOINT ["java", "-jar", "application.jar"]