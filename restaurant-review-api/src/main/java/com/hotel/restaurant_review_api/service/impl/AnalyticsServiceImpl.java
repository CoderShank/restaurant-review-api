package com.hotel.restaurant_review_api.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hotel.restaurant_review_api.domain.ReviewStatus;
import com.hotel.restaurant_review_api.dto.RestaurantResponse;
import com.hotel.restaurant_review_api.repository.RestaurantRepository;
import com.hotel.restaurant_review_api.repository.ReviewRepository;
import com.hotel.restaurant_review_api.service.AnalyticsService;
import java.util.AbstractMap;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {
  private final RestaurantRepository restaurants; private final ReviewRepository reviews;

  @Cacheable("avgRating")
  public Double averageApprovedRating(Long restaurantId){
    return reviews.averageRating(restaurantId, ReviewStatus.APPROVED);
  }

  @Cacheable("top3")
  public List<RestaurantResponse> top3ByCuisine(String cuisine) {
      return restaurants.findByCuisineTypeIgnoreCase(cuisine).stream()
          .map(r -> new AbstractMap.SimpleEntry<>(r, reviews.averageRating(r.getId(), ReviewStatus.APPROVED)))
          .sorted((a, b) -> {
              var A = a.getValue();
              var B = b.getValue();
              if (A == null && B == null) return 0;
              if (A == null) return 1;
              if (B == null) return -1;
              return Double.compare(B, A);
          })
          .limit(3)
          .map(e -> RestaurantResponse.builder()
              .id(e.getKey().getId())
              .name(e.getKey().getName())
              .cuisineType(e.getKey().getCuisineType())
              .address(e.getKey().getAddress())
              .priceRange(e.getKey().getPriceRange())
              .averageApprovedRating(e.getValue())
              .build())
          .toList();
  }

}