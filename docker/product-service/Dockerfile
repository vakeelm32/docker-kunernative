FROM tomcat:8.5.47-jdk8-openjdk

MAINTAINER Vakeel "contact@vakeel.com"

EXPOSE 8080

RUN rm -rf ./webapps/*

COPY target/app.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]