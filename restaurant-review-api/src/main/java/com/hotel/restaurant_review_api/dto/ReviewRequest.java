package com.hotel.restaurant_review_api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReviewRequest {
  @NotNull @Min(1) @Max(5) private Integer rating;
  @Size(max=2000) private String comment;
  @NotNull @PastOrPresent private LocalDate visitDate;
}