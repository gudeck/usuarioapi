FROM openjdk:16
MAINTAINER gudeck
COPY target/usuarioapi-0.0.1-SNAPSHOT.jar usuarioapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usuarioapi-0.0.1-SNAPSHOT.jar"]