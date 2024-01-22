# ToDo List App

## Overview

This project is a Spring Boot API serving as a backend for a ToDo list application. Users can perform basic CRUD operations to manage their ToDo items. The API is built with Java 17 and Spring Boot 3.2.1, utilizing MongoDB as the database.

The MongoDB instance is hosted on MongoDB Atlas using the free package, allowing data management from anywhere without additional database configuration. The connection URI is stored in the application.yml file. It's important to note that in production environments, sensitive information like the URI should be stored securely and not included in the project repository.

## Getting Started

Prerequisites
Before you begin, ensure you have the following software installed:

- Java 17
- Maven

## Running the Application

To run the application, use the following command:

- mvn spring-boot:run

The API will be accessible at http://localhost:8080.
