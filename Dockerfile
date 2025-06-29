FROM openjdk:8-jre-alpine
WORKDIR /app
COPY target/bca-1.0-SNAPSHOT-jar-with-dependencies.jar ./bca.jar
ENTRYPOINT ["java", "-jar", "bca.jar"]