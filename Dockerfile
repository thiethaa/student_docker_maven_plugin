FROM openjdk:latest
ARG JAR_FILE
ADD ${JAR_FILE} student_docker_plugin.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","student_docker_plugin.jar"]