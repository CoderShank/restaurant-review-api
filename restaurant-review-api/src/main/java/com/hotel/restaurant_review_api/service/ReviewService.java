package com.hotel.restaurant_review_api.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hotel.restaurant_review_api.dto.ReviewRequest;
import com.hotel.restaurant_review_api.dto.ReviewResponse;

//service/ReviewService.java
public interface ReviewService {
ReviewResponse submit(Long restaurantId, ReviewRequest req);
Page<ReviewResponse> listForRestaurant(Long restaurantId, Pageable pageable);
ReviewResponse approve(Long reviewId);
}

