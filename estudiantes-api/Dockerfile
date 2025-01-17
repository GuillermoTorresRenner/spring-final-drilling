FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/estudiantes-api-0.0.1-SNAPSHOT.jar estudiantes-api.jar
ENTRYPOINT ["java","-jar","/estudiantes-api.jar"]