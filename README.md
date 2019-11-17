# Restaurant Service

This project focuses on providing automated services for customers to 
obtain information about restaurants. The information requested can include ordering food,
listing available meals, checking for open reservations and finding a great restaurant in your city!
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites and Installation

Download and Install [JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

Set Environment Variable
```
JAVA_HOME: C:\path\to\JavaSDK
```

## Directory Structure

```
└── src
    └── main
        └── java
            └── BackApp
                └── Application.java
                └── Restaurant.java
                └── RestaurantController.java
                └── Service.java
            └── resources
                └── Restaurant.json
        └── test
            └── java
                └── BackApp
                    └── RestaurantControllerTest.java
                    └── RestaurantTest
                
```

## Running

```
./mvnw spring-boot:run
```

Then open your browser and go to 

```
http://localhost:8080
```

There you can make POST, GET, PUT, DELETE requests

## Deployment

* [Travis-CI](https://travis-ci.org/alizhan1/Java_Project/builds/612503720) - continuous integration service

## Dependency management

* [Maven](https://maven.apache.org/guides/) - dependency management tool

## Authors

* **Alizhan Akhmetkaliyev**
* **Nathaniel Remy**
