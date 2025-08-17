# Restaurant Review API 🍴

A Spring Boot REST API for managing restaurants and reviews.  
This project demonstrates core Java, Spring Boot, RESTful APIs, and basic authentication with Spring Security.

---

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA (Hibernate)
- PostgreSQL (Database)
- Maven
- Swagger (for API documentation)

---

## Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/<your-username>/restaurant-review-api.git
cd restaurant-review-api

**### 2. Configure Database**

Update your application.properties (or application.yml) file with your PostgreSQL credentials:

spring.datasource.url=jdbc:postgresql://localhost:5432/restaurant_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

**### 3. Build and Run**


**### 4. Access the API**

Base URL: http://localhost:8080/api

Example endpoints:

[https://web.postman.co/workspace/cab50131-2390-4c6f-9248-a6e7935726f6/collection/42350282-9f145d6f-b0a0-4cad-9e33-700826f1bdc0?action=share&source=copy-link&creator=42350282](url)

🔑 Authentication

Basic Auth with in-memory users:

user / user123 → ROLE_USER

admin / admin123 → ROLE_ADMIN
