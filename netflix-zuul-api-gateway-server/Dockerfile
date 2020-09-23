FROM openjdk:8-jdk-alpine
EXPOSE 8765
ADD target/*.jar app.jar
# ENV JAVA_OPTS=""
ENTRYPOINT [ "java","-jar","app.jar" ]