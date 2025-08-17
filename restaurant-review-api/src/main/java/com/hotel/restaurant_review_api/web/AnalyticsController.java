package com.hotel.restaurant_review_api.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.restaurant_review_api.dto.RestaurantResponse;
import com.hotel.restaurant_review_api.service.AnalyticsService;

import lombok.RequiredArgsConstructor;

//web/AnalyticsController.java
@RestController @RequestMapping("/api/analytics") @RequiredArgsConstructor
public class AnalyticsController {
private final AnalyticsService analytics;

@GetMapping("/average-rating/{restaurantId}") public Double avg(@PathVariable Long restaurantId){
 return analytics.averageApprovedRating(restaurantId);
}
@GetMapping("/top3") public List<RestaurantResponse> top3(@RequestParam String cuisine){
 return analytics.top3ByCuisine(cuisine);
}
}

