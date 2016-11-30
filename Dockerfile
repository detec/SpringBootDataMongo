FROM java

MAINTAINER Andrii Duplyk

COPY target/SpringBootDataMongoDB.jar /usr/src/SpringBootDataMongoDB.jar
CMD java -jar /usr/src/SpringBootDataMongoDB.jar



