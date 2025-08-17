package com.hotel.restaurant_review_api.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.restaurant_review_api.domain.Restaurant;
import com.hotel.restaurant_review_api.domain.Review;
import com.hotel.restaurant_review_api.domain.ReviewStatus;

//repository/ReviewRepository.java
public interface ReviewRepository extends JpaRepository<Review, Long> {
Page<Review> findByRestaurant(Restaurant r, Pageable pageable);

@Query("select avg(r.rating) from Review r where r.restaurant.id=:restaurantId and r.status=:status")
Double averageRating(@Param("restaurantId") Long restaurantId, @Param("status") ReviewStatus status);
}

