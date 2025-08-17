package com.hotel.restaurant_review_api.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotel.restaurant_review_api.dto.ApiError;

import jakarta.servlet.http.HttpServletRequest;

//web/GlobalExceptionHandler.java
@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(NotFoundException.class)
public ResponseEntity<ApiError> notFound(NotFoundException ex, HttpServletRequest req){
 return ResponseEntity.status(HttpStatus.NOT_FOUND)
   .body(new ApiError(Instant.now(),404,"Not Found",ex.getMessage(),req.getRequestURI(),null));
}

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ApiError> validation(MethodArgumentNotValidException ex, HttpServletRequest req){
 var errs = ex.getBindingResult().getFieldErrors().stream()
   .map(fe -> fe.getField()+": "+fe.getDefaultMessage()).toList();
 return ResponseEntity.badRequest().body(
   new ApiError(Instant.now(),400,"Validation Failed","Input validation failed",req.getRequestURI(),errs));
}

@ExceptionHandler(Exception.class)
public ResponseEntity<ApiError> other(Exception ex, HttpServletRequest req){
 return ResponseEntity.status(500).body(
   new ApiError(Instant.now(),500,"Internal Server Error",ex.getMessage(),req.getRequestURI(),null));
}
}
