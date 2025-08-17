package com.hotel.restaurant_review_api.dto;

import java.time.LocalDate;

import com.hotel.restaurant_review_api.domain.ReviewStatus;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ReviewResponse {
  private Long id; private Long restaurantId; private int rating;
  private String comment; private LocalDate visitDate; private ReviewStatus status;
}