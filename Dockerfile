FROM maven:3.6.3-openjdk-16
COPY ./ ./
RUN mvn clean package
CMD["java", "-jar", "target/usuarioapi-0.0.1-SNAPSHOT.jar"]