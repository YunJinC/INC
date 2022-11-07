FROM openjdk:8-jdk-alpine

COPY ./* /opt/

CMD ["java", "-jar", "-Dspring.profiles.active=prd", "/opt/demo-0.0.1-SNAPSHOT.jar"]
