# Restaurant Review API 🍴

A Spring Boot REST API for managing restaurants and reviews.  
This project demonstrates core Java, Spring Boot, RESTful APIs, and basic authentication with Spring Security.

---

## 🚀 Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA (Hibernate)
- PostgreSQL (Database)
- Maven
- Swagger (for API documentation)

---

## ⚙️ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/<your-username>/restaurant-review-api.git
cd restaurant-review-api

2. Configure Database

Update your application.properties (or application.yml) file with your PostgreSQL credentials:

spring.datasource.url=jdbc:postgresql://localhost:5432/restaurant_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3. Build and Run


4. Access the API

Base URL: http://localhost:8080/api

Example endpoints:

GET /api/restaurants → fetch all restaurants

POST /api/restaurants → add a restaurant

GET /api/reviews → fetch all reviews

🔑 Authentication

Basic Auth with in-memory users:

user / user123 → ROLE_USER

admin / admin123 → ROLE_ADMIN
