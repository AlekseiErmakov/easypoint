FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/easypoint-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]