package com.hotel.restaurant_review_api.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hotel.restaurant_review_api.domain.Review;
import com.hotel.restaurant_review_api.domain.ReviewStatus;
import com.hotel.restaurant_review_api.dto.ReviewRequest;
import com.hotel.restaurant_review_api.dto.ReviewResponse;
import com.hotel.restaurant_review_api.exception.NotFoundException;
import com.hotel.restaurant_review_api.repository.RestaurantRepository;
import com.hotel.restaurant_review_api.repository.ReviewRepository;
import com.hotel.restaurant_review_api.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
//service/impl/ReviewServiceImpl.java
@Service @RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
private final RestaurantRepository restaurants; private final ReviewRepository reviews;

@Transactional @CacheEvict(value = {"avgRating","top3"}, allEntries = true)
public ReviewResponse submit(Long restaurantId, ReviewRequest req){
 var rest = restaurants.findById(restaurantId).orElseThrow(() -> new NotFoundException("Restaurant not found: "+restaurantId));
 var saved = reviews.save(Review.builder().restaurant(rest).rating(req.getRating())
   .comment(req.getComment()).visitDate(req.getVisitDate()).status(ReviewStatus.PENDING).build());
 return toResp(saved);
}

public Page<ReviewResponse> listForRestaurant(Long restaurantId, Pageable p){
 var rest = restaurants.findById(restaurantId).orElseThrow(() -> new NotFoundException("Restaurant not found: "+restaurantId));
 return reviews.findByRestaurant(rest, p).map(this::toResp);
}

@Transactional @CacheEvict(value = {"avgRating","top3"}, allEntries = true)
public ReviewResponse approve(Long reviewId){
 var rev = reviews.findById(reviewId).orElseThrow(() -> new NotFoundException("Review not found: "+reviewId));
 rev.setStatus(ReviewStatus.APPROVED);
 return toResp(rev);
}

private ReviewResponse toResp(Review r){
 return ReviewResponse.builder().id(r.getId()).restaurantId(r.getRestaurant().getId())
   .rating(r.getRating()).comment(r.getComment()).visitDate(r.getVisitDate()).status(r.getStatus()).build();
}
}
