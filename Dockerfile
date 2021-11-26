FROM openjdk:11-jre
ARG JAR_FILE=app.jar
ARG DB_FILE=notes.db
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
COPY ${DB_FILE} notes.db
ENTRYPOINT ["java","-jar","app.jar"]