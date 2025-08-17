package com.hotel.restaurant_review_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity  // Enable method-level security annotations
@EnableCaching
public class RestaurantReviewApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewApiApplication.class, args);
		
		System.out.println("Restaurant Review API is running...");
	}

}

