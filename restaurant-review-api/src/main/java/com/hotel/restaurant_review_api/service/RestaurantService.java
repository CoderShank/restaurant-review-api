package com.hotel.restaurant_review_api.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hotel.restaurant_review_api.dto.RestaurantRequest;
import com.hotel.restaurant_review_api.dto.RestaurantResponse;

public interface RestaurantService {
	  RestaurantResponse create(RestaurantRequest req);
	  RestaurantResponse get(Long id);
	  Page<RestaurantResponse> list(Pageable pageable);
	}