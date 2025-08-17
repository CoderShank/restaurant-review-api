package com.hotel.restaurant_review_api.dto;

import com.hotel.restaurant_review_api.domain.PriceRange;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RestaurantRequest {
@NotBlank private String name;
@NotBlank private String cuisineType;
@NotBlank private String address;
@NotNull  private PriceRange priceRange;
}
