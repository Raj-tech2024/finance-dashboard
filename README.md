# 💰 Finance Dashboard Backend System

##  Overview

This is a Spring Boot backend system for a Finance Dashboard that allows users to manage financial records securely using JWT authentication, role-based access control (RBAC), pagination, and Swagger API documentation.

The project focuses on real-world backend development practices like security, scalability, clean architecture, and testing.

---

## ️ Architecture

The project follows layered architecture:

Controller → Service → Repository → Database

### Layers:
- Controller: Handles HTTP requests
- Service: Business logic layer
- Repository: Database operations using Spring Data JPA
- Entity: Database models

---

##  Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- MySQL
- Swagger (OpenAPI)
- JUnit + Mockito

---

##  Security

### Authentication
- JWT-based stateless authentication
- Token generated after login
- Token required for accessing secured APIs

### Authorization (RBAC)
- ADMIN → Full access
- ANALYST → Read + analytics access
- VIEWER → Read-only access

---

##  Features

### User Management
- Create users with roles
- Password encrypted using BCrypt

### Financial Records
- Create, update, delete records
- Filter by type (INCOME / EXPENSE)

### Pagination
- Pageable support for efficient data loading

### Swagger UI
- API testing and documentation interface

### Unit Testing
- JUnit + Mockito for service layer testing

---

##  API Endpoints

### Authentication
POST /auth/login

### Users (ADMIN only)
POST /users  
GET /users

### Financial Records
GET /records?page=0&size=5  
POST /records  
PUT /records/{id}  
DELETE /records/{id}

### Dashboard
GET /dashboard/summary

---

##  Swagger UI

http://localhost:8080/swagger-ui/index.html

---

##  Setup Instructions

### 1. Clone Repository
git clone <repo-url>  
cd finance-dashboard

---

### 2. Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/finance_db  
spring.datasource.username=root  
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true

---

### 3. Run Application

mvn spring-boot:run

---

### 4. Run Tests

mvn test

---

##  Authentication Flow

1. Create user via /users API
2. Login via /auth/login
3. Get JWT token
4. Add token in request header:

Authorization: Bearer <token>

---

##  Assumptions

- Roles are predefined (ADMIN, ANALYST, VIEWER)
- No frontend UI (Swagger/Postman used)
- JWT used for stateless authentication
- MySQL database used

---

##  Trade-offs

- No refresh token system (simplified authentication)
- No frontend UI (Swagger used instead)
- Basic RBAC (no dynamic permission engine)
- No caching layer (Redis not used)

---

##  Testing Strategy

- JUnit + Mockito used
- Service layer tested independently
- Repository mocked for isolation

---

##  Key Highlights

- JWT authentication system
- Role-based access control (RBAC)
- Pagination support
- Swagger API documentation
- Clean layered architecture
- Unit tested service layer

---

##  Future Improvements

- Refresh token implementation
- Advanced filtering and search
- Docker support
- CI/CD pipeline
- Integration tests (MockMvc)
- Cloud deployment (AWS / Render)

---

##  Author - RAJ NIHALE

Finance Dashboard Backend Project (Spring Boot)