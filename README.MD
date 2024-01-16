# spring-boot-rest-file-validation

This repository demonstrates the usage of `JSR-303` [Bean Validation](https://beanvalidation.org/1.0/spec/) in
combination with `Spring Boot`, `REST-Endpoints` and a custom `ConstraintValidator` to control which files, file-types
and file-sizes may be uploaded.

## Technologies used

- Java 17
- Maven
- Spring Boot
- Jakarta Validation API

## Run application

Run the spring boot application (automatically applies all existing migration changesets)
> ./mvnw spring-boot:run
