package com.hotel.restaurant_review_api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

import com.hotel.restaurant_review_api.dto.ReviewRequest;
import com.hotel.restaurant_review_api.dto.ReviewResponse;
import com.hotel.restaurant_review_api.repository.ReviewRepository;
import com.hotel.restaurant_review_api.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class ReviewController {
private final ReviewService service;

@PostMapping("/restaurants/{restaurantId}/reviews")
@ResponseStatus(HttpStatus.CREATED) @PreAuthorize("hasAnyRole('USER','ADMIN')")
public ReviewResponse submit(@PathVariable Long restaurantId, @Valid @RequestBody ReviewRequest req){
 return service.submit(restaurantId, req);
}

@GetMapping("/restaurants/{restaurantId}/reviews")
public Page<ReviewResponse> list(@PathVariable Long restaurantId, @PageableDefault(size=10, sort="visitDate") Pageable p){
 return service.listForRestaurant(restaurantId, p);
}

@PostMapping("/reviews/{reviewId}/approve") @PreAuthorize("hasRole('ADMIN')")
public ReviewResponse approve(@PathVariable Long reviewId){ return service.approve(reviewId); }
}


