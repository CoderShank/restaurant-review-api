package com.hotel.restaurant_review_api.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Review {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne(optional = false, fetch = FetchType.LAZY)
private Restaurant restaurant;

@Column(nullable = false) private int rating; // 1-5
@Column(length = 2000) private String comment;
@Column(nullable = false) private LocalDate visitDate;

@Enumerated(EnumType.STRING) @Column(nullable = false)
private ReviewStatus status;
}

