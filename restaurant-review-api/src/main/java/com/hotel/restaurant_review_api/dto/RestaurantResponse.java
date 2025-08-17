package com.hotel.restaurant_review_api.dto;

import com.hotel.restaurant_review_api.domain.PriceRange;

import lombok.Builder;
import lombok.Data;

//dto/RestaurantResponse.java
@Data @Builder
public class RestaurantResponse {
private Long id; private String name; private String cuisineType;
private String address; private PriceRange priceRange;
private Double averageApprovedRating; // nullable if none
}
