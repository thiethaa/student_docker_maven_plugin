FROM openjdk:latest
#ARG JAR_FILE
ADD target/student-docker.jar student-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","student-docker.jar"]