# Title of the project #
Gateway Service

# Description of the project
Reservation service is the API Gateway serving as the sole entry point to the system. All access to other microservices must be done via the gateway URL.

Note : it must be launched right after the eureka microservice (registre-service) has been launched and before all business microservices.

#Requirements
1. Java 17
2. Maven 3.8.6


#Dependencies
1. spring-cloud-starter-netflix-eureka-client
2. spring-boot-starter-test
3. spring-cloud-starter-gateway

#Build
command line : mvn clean install (see jenkinsfile)

#Packaging the application
command line : mvn clean package -DskipTests (see the project's jenkins file)

#Deploy
command line : mvn spring-boot:run
