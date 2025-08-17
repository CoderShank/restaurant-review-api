package com.hotel.restaurant_review_api.dto;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ApiError {
private Instant timestamp; private int status; private String error;
private String message; private String path; private List<String> validationErrors;
}

