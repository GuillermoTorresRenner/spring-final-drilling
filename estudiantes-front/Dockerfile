FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/estudiantes-front-0.0.1-SNAPSHOT.jar estudiantes-front.jar
ENTRYPOINT ["java","-jar","/estudiantes-front.jar"]