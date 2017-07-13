FROM java

MAINTAINER Andrii Duplyk

COPY target/SpringBootDataMongoDB.jar /usr/src/SpringBootDataMongoDB.jar
EXPOSE 8080
CMD java -jar /usr/src/SpringBootDataMongoDB.jar



