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
![img.png](images/img.png)

In this app we are using api-gateway for expose our APIs and keycloak identity server for secure them, 
we test documentale-api via api-gateway with this url: http://localhost:8080/documentale-api/test
we should get a login page like image below
![img_1.png](images/img_1.png)

and if we try to call our api directly we should get 401 Error cod (unauthorized)
http://localhost:8091/test

some test via postman:

we try to create a content for that we should configure our postman with
our identity server configuration like client-id and client-secret
![img_3.png](images/img_3.png)
![img_4.png](images/img_4.png)
![img_6.png](images/img_6.png)
![img_7.png](images/img_7.png)




