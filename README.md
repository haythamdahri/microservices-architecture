# Spring Cloud Architecture Based Application
# Microservices with Spring Boot and Spring Cloud

Make microservices cloud ready with Spring Cloud

- Establishing Communication between Microservices
- Centralized Microservice Configuration with Spring Cloud Config Server
- Using Spring Cloud Bus to exchange messages about Configuration updates
- Simplify communication with other Microservices using Feign REST Client
- Implement client side load balancing with Ribbon
- Implement dynamic scaling using Eureka Naming Server and Ribbon
- Implement API Gateway with Zuul
- Implement Distributed tracing with Spring Cloud Sleuth and Zipkin
- Implement Fault Tolerance with Zipkin

## Microservices Step by Step

#### Spring Cloud Config Server
- Limits Microservice and Spring Cloud Config Server
- Setting up Limits Microservice
- Creating a hard coded limits service
- Enhance limits service to pick up configuration from application properties
- Setting up Spring Cloud Config Server
- Installing Git
- Creating Local Git Repository
- Connect Spring Cloud Config Server to Local Git Repository
- Configuration for Multiple Environments in Git Repository
- Connect Limits Service to Spring Cloud Config Server
- Configuring Profiles for Limits Service
- A review of Spring Cloud Config Server

#### Implementing 2 Microservices with Eureka Naming Server, Ribbon and Feign
- Introduction to Currency Conversion and Currency Exchange Microservices TODO
- Setting up Currency Exchange Microservice
- Create a simple hard coded currency exchange service
- Setting up Dynamic Port in the the Response
- Configure JPA and Initialized Data
- Create a JPA Repository
- Setting up Currency Conversion Microservice
- Creating a service for currency conversion
- Invoking Currency Exchange Microservice from Currency Conversion Microservice
- Using Feign REST Client for Service Invocation
- Setting up client side load balancing with Ribbon
- Running client side load balancing with Ribbon
- Understand the need for a Naming Server
- Setting up Eureka Naming Server
- Connecting Currency Conversion Microservice to Eureka
- Connecting Currency Exchange Microservice to Eureka
- Distributing calls using Eureka and Ribbon
- A review of implementing Eureka, Ribbon and Feign

#### API Gateways and Distributed Tracing
- Introduction to API Gateways
- Setting up Zuul API Gateway
- Implementing Zuul Logging Filter
- Executing a request through Zuul API Gateway
- Setting up Zuul API Gateway between microservice invocations
- Introduction to Distributed Tracing
- Implementing Spring Cloud Sleuth
- Introduction to Distributed Tracing with Zipkin
- Installing Rabbit MQ
- Setting up Distributed Tracing with Zipkin
- Connecting microservices to Zipkin
- Using Zipkin UI Dashboard to trace requests

#### Spring Cloud Bus and Hysterix
- Understanding the need for Spring Cloud Bus
- Implementing Spring Cloud Bus
- Fault Tolerance with Hystrix


## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Limits Service | 8080, 8081, ... |
| Spring Cloud Config Server | 8888 |
|  |  |
| Currency Exchange Service | 8000, 8001, 8002, ..  |
| Currency Conversion Service | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |


## URLs

|     Application       |     URL          |
| ------------- | ------------- |
| Limits Service | http://localhost:8080/limits POST -> http://localhost:8080/actuator/refresh|
|Spring Cloud Config Server| http://localhost:8888/limits-service/default http://localhost:8888/limits-service/dev |
|  Currency Converter Service - Direct Call| http://localhost:8100/currency-converter/from/USD/to/MAD/quantity/10|
|  Currency Converter Service - Feign| http://localhost:8100/currency-converter/from/EUR/to/MAD/quantity/10000|
| Currency Exchange Service | http://localhost:8000/currency-exchange/from/EUR/to/MAD http://localhost:8001/currency-exchange/from/USD/to/MAD|
| Eureka | http://localhost:8761/|
| Zuul - Currency Exchange & Exchange Services | http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/MAD http://localhost:8765/currency-conversion-service/currency-converter/from/USD/to/MAD/quantity/10|
| Zipkin | http://localhost:9411/zipkin/ |
| Spring Cloud Bus Refresh | http://localhost:8080/bus/refresh |

## Zipkin Installation

Quick Start Page
- https://zipkin.io/pages/quickstart

Downloading Zipkin Jar
- https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec

Command to run
```
RABBIT_URI=amqp://localhost java -jar zipkin-server-2.5.2-exec.jar
```

## VM Argument

-Dserver.port=8001

## Commands

```
mkdir git-configuration-repo
cd git-configuration-repo/
git init
git add -A
git commit -m "Init commit"
```

## Spring Cloud Configuration

```
spring.cloud.config.failFast=true

```

## More Reading about Microservices
- Design and Governance of Microservices
    - https://martinfowler.com/microservices/
- 12 Factor App 
    - https://12factor.net/
    - https://dzone.com/articles/the-12-factor-app-a-java-developers-perspective
- Spring Cloud
    - http://projects.spring.io/spring-cloud/
