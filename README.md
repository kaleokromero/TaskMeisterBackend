# TaskMeisterBackend

Welcome to **TaskMeisterBackend**, a robust and efficient task management system backend developed to streamline your workflow and enhance productivity. 
This project marks my first experience using Spring Boot, and it has been an exciting journey of learning and implementation. This API was used in TaskMeister Front project
where using Axios library and REACT i created the UI for this interesting FULL STACK application 

## Sobre o projeto
Este projeto marca a minha primeira expêriencia usando SpringBoot, e foi criada visando ser um sistema de anotação de tarefas. Esta API foi usada no projeto TaskMeister Front
aonde foi implementado em uma UI criada usando REACT e Axios!
## Features

- **Task Management**: Create, update, delete, and manage tasks efficiently.
- **API Documentation**: Comprehensive API documentation with Swagger.

## Technologies and Libraries

- **Java**: The primary programming language used for the backend development.
- **Spring Boot**: The framework that simplifies the bootstrapping and development of new Spring applications.
- **Spring Data JPA**: Simplifies data access and persistence with JPA.
- **Hibernate**: Used for ORM (Object-Relational Mapping) with the database.
- **MySQL**: The relational database management system used for data storage.
- **JUNIT**: For testing and make sure everything is running ok!
- **Swagger**: For API documentation and testing.
- **Lombok**: To reduce boilerplate code with annotations.
- **Maven**: For project management and dependency management.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or later
- Maven
- MySQL

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/kaleokromero/TaskMeisterBackend.git
   ```

2. Navigate to the project directory:
   ```bash
   cd TaskMeisterBackend
   ```

3. Configure the database settings in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/taskmeister
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword
   ```

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Usage

Once the application is running, you can access the API documentation at `http://localhost:8080/swagger-ui.html` to explore and test the available endpoints.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

---
