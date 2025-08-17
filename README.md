# Restaurant Review API 🍴

A Spring Boot REST API for managing restaurants and reviews.  
This project demonstrates core Java, Spring Boot, RESTful APIs, and basic authentication with Spring Security.

---

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA (Hibernate)
- h2 Database
- Maven
- Swagger (for API documentation)

---

## Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/CoderShank/restaurant-review-api.git
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

  -    Create Restaurants only admin can add
       Authorization -> basic authentication -> username  = "admin" and password = "admin123"
       POST   http://localhost:8080/api/restaurants

  -    Fetch All Restaurant for only Admin implemented pagination
       Authorization -> basic authentication -> username  = "admin" and password = "admin123"
       GET    http://localhost:8080/api/restaurants?page=0&size=5

  -    List all Restaurant with default pagination
       Authorization -> basic authentication -> username  = "admin" and password = "admin123"
       GET    http://localhost:8080/api/restaurants

  -    Review on restaurant by user only
       Authorization -> basic authentication -> username  = "user" and password = "user123"
       POST   http://localhost:8080/api/restaurants/1/reviews

  -    Fetch restaurant reviews based on restaurant id
       NO Authorization 
       GET   http://localhost:8080/api/restaurants/1/reviews

  -    Approve Review posted by users and approved only when admin approved it
       Authorization -> basic authentication -> username  = "admin" and password = "admin123"
       POST  http://localhost:8080/api/reviews/1/approve

  -    Give average rating using restaurant id
       No Authorization
       GET   http://localhost:8080/api/analytics/average-rating/1
  
  -    Fetch top 3 Restaurant using cuisineType
       No Authorization
       GET   http://localhost:8080/api/analytics/top3?cuisine=Italian
      
🔑 Authentication

Basic Auth with in-memory users:

user / user123 → ROLE_USER

admin / admin123 → ROLE_ADMIN
