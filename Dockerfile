FROM openjdk:latest
ARG JAR_FILE
ADD ${JAR_FILE} student-docker-build-push-from-maven-plugin.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","student-docker-build-push-from-maven-plugin.jar"]