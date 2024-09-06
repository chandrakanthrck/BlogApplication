# Blog Application

## Overview
This is a **Spring Boot** blog application project based on the tutorial by **Durgesh** on YouTube. The application allows users to create, read, update, and delete blog posts, and provides basic authentication for users.

## Features
- **User Management**: Register and manage users.
- **CRUD Operations**: Create, read, update, and delete blog posts.
- **Categories**: Manage blog categories.
- **Authentication**: Basic user authentication and authorization.
- **Pagination**: View posts with pagination support.
- **Comments**: Users can comment on posts.

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **MySQL** (or any preferred database)
- **Hibernate**
- **Thymeleaf** (for front-end)
- **Maven**

## Setup and Run

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL or other database for storing user and blog data

### Clone the Repository
```bash
git clone https://github.com/your-username/blog-application.git
cd blog-application
```

Configure Database
Update the database connection details in src/main/resources/application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=root
spring.datasource.password=your_password
```
### Run the Application
```bash
mvn spring-boot:run
```

### API Endpoints
- **POST** `/api/auth/register` - Register a new user
- **POST** `/api/auth/login` - Login and obtain JWT token
- **GET** `/api/posts` - Get all blog posts
- **GET** `/api/posts/{id}` - Get a specific post by ID
- **POST** `/api/posts` - Create a new post
- **PUT** `/api/posts/{id}` - Update an existing post
- **DELETE** `/api/posts/{id}` - Delete a post
- **GET** `/api/categories` - Get all categories

### License
This project is licensed under the MIT License.
