package com.hotel.restaurant_review_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.restaurant_review_api.domain.PriceRange;
import com.hotel.restaurant_review_api.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	  List<Restaurant> findByCuisineTypeIgnoreCase(String cuisineType);
	  List<Restaurant> findByNameContainingIgnoreCase(String name);
	
	  List<Restaurant> findByCuisineType(String cuisineType);
	
	  List<Restaurant> findByPriceRange(PriceRange priceRange);
	


}
