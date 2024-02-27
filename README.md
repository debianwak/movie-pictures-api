# Moviepictures API

This API provides endpoints to manage and retrieve movie pictures, including voting on them and getting details.

### Prerequisites

Make sure you have the following installed:

    Java JDK 17
    Maven

### Compiling the Application

To compile and run tests  (It will generate the code coverage report by default), you can use:

```bash
mvn clean test
```

(Optional) To skip run unit tests and create code coverage report, then run:
```bash
mvn clean install -Dmaven.test.skip=true -Djacoco.skip=true
```


### Running the Application

To run the application locally, you can use:

```bash

mvn spring-boot:run
```

The application will start on http://localhost:8080.

To see the ```/movies``` endpoint from the browser open: http://localhost:8080/movies

### Technologies Used

    Java
    Spring Boot
    Maven
    H2 Database (for demo purposes)

### Swagger API Documentation

You can access the API documentation using Swagger UI. Visit the following URL in your browser:

[Swagger UI - Moviepictures API](http://localhost:8080/swagger-ui/index.html)
### Open API Documentation

### PostMan API collection
https://api.postman.com/collections/9399182-442dee2e-90de-4de1-8e43-be8e52efb6af?access_key=PMAT-01HQM0C453X8ZEGMZF51WA7YF6


You can access the Open API documentation visiting the following URL in your browser:
http://localhost:8080/v3/api-docs

### Running Tests and Generating Code Coverage Report

To run tests and generate a code coverage report, use the following Maven commands:

```bash
mvn clean test jacoco:report
```
Skipping Code Coverage Report

If you want to skip generating the code coverage report during the build, you can use:

```bash

mvn clean install -Djacoco.skip=true
```
### Viewing the Code Coverage Report

After running tests with coverage, you can find the report in the target/site/jacoco directory of your project. Open the following file in a browser to view the detailed coverage report:

```bash

target/site/jacoco/index.html
```