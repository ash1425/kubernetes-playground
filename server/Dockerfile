FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG GIT_COMMIT=unspecified
LABEL git_commit=${GIT_COMMIT}
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]