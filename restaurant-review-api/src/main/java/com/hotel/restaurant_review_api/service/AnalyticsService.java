package com.hotel.restaurant_review_api.service;

import java.util.List;

import com.hotel.restaurant_review_api.dto.RestaurantResponse;

public interface AnalyticsService {
	  Double averageApprovedRating(Long restaurantId);
	  List<RestaurantResponse> top3ByCuisine(String cuisineType);
	}
