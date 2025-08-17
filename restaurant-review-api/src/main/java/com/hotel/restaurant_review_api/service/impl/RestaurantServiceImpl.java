package com.hotel.restaurant_review_api.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hotel.restaurant_review_api.domain.Restaurant;
import com.hotel.restaurant_review_api.domain.ReviewStatus;
import com.hotel.restaurant_review_api.dto.RestaurantRequest;
import com.hotel.restaurant_review_api.dto.RestaurantResponse;
import com.hotel.restaurant_review_api.exception.NotFoundException;
import com.hotel.restaurant_review_api.repository.RestaurantRepository;
import com.hotel.restaurant_review_api.repository.ReviewRepository;
import com.hotel.restaurant_review_api.service.RestaurantService;

import lombok.RequiredArgsConstructor;


@Service @RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
private final RestaurantRepository restaurants; private final ReviewRepository reviews;

public RestaurantResponse create(RestaurantRequest r){
 var saved = restaurants.save(Restaurant.builder()
   .name(r.getName()).cuisineType(r.getCuisineType()).address(r.getAddress()).priceRange(r.getPriceRange()).build());
 return toResp(saved, null);
}
public RestaurantResponse get(Long id){
 var r = restaurants.findById(id).orElseThrow(() -> new NotFoundException("Restaurant not found: "+id));
 var avg = reviews.averageRating(id, ReviewStatus.APPROVED);
 return toResp(r, avg);
}
public Page<RestaurantResponse> list(Pageable p){
 return restaurants.findAll(p).map(r -> toResp(r, reviews.averageRating(r.getId(), ReviewStatus.APPROVED)));
}
private RestaurantResponse toResp(Restaurant r, Double avg){
 return RestaurantResponse.builder().id(r.getId()).name(r.getName()).cuisineType(r.getCuisineType())
   .address(r.getAddress()).priceRange(r.getPriceRange()).averageApprovedRating(avg).build();
}
}
