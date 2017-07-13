# Spring Boot Data MongoDB #

This is a template project to build with Maven for DAO layer and REST service with Spring Boot, Spring Data and MongoDB server. Its core components are:

- Spring Boot 1.5;
- Jackson Databind 2.8 with JSR310 support;
- sl4j/Logback;
- MongoDB 3.4;
- Springfox swagger 2.7;
- Java 8.

DAO layer is built with interfaces that extend Repository interface in Spring Data, no actual implementation is needed. Service layer is omitted. There is a sample Customer
class that utilizes '/customer/' endpoint. To view automatic Swagger.io documentation use address /swagger-ui.html.

Sample rest controller supports exception handling and JSON pretty printing. Change src/main/resources/application.properties to specify your MongoDB database name or remove
relevant setting to use default one.
To test this template run this project as a compiled JAR and call endpoint GET http://localhost:8080/test . It should return 'true' in response body. You can also use additional endpoint to check current server time: GET http://localhost:8080/now . Requests should be accompanied by "Accept" and "Content-Type" headers with value application/json.  