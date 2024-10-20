# documentale-mi

Requirements before start:
-
- JDK 17
- Maven
- IDEA (IntelliJ IDEA Community Edition / Eclipse )

First step:
- ensure the discovery server and api-gateway are up and running
- run every microservice with maven command ``` mvn spring-boot:run ```
- ensure all microservices are up and running
- navigate to discovery server at url http://localhost:8761 all the services should be registered
![img.png](img.png)

In this app we are using api-gateway for expose our APIs and keycloak identity server for secure them, 
we test documentale-api via api-gateway with this url: http://localhost:8080/documentale-api/test
we should get a login page like image below
![img_1.png](img_1.png)

and if we try to call our api directly we should get 401 Error cod (unauthorized)
http://localhost:8091/test


