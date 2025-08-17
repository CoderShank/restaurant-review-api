package com.hotel.restaurant_review_api.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.hotel.restaurant_review_api.dto.RestaurantRequest;
import com.hotel.restaurant_review_api.dto.RestaurantResponse;
import com.hotel.restaurant_review_api.service.RestaurantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

//web/RestaurantController.java
@RestController @RequestMapping("/api/restaurants") @RequiredArgsConstructor
public class RestaurantController {
private final RestaurantService service;

@PostMapping @ResponseStatus(HttpStatus.CREATED) @PreAuthorize("hasRole('ADMIN')")
public RestaurantResponse create(@Valid @RequestBody RestaurantRequest req){ return service.create(req); }

@GetMapping("/{id}") public RestaurantResponse get(@PathVariable Long id){ return service.get(id); }

@GetMapping public Page<RestaurantResponse> list(@PageableDefault(size=10, sort="name") Pageable p){ return service.list(p); }
}

