FROM eclipse-temurin:21.0.4_7-jdk

LABEL maintainer="sehmusaydogdu47@gmail.com"

ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]