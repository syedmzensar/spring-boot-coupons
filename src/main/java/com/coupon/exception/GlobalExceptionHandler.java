package com.coupon.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CouponNotFoundException.class)
	public ResponseEntity<Object> resourceNotFoundException(CouponNotFoundException ex, WebRequest request) {
		ErrorResponse message = new ErrorResponse(ex.getMessage());
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", message);
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CouponAlreadyExistsException.class)
	public ResponseEntity<Object> resourceAlreadyExistsException(CouponAlreadyExistsException ex, WebRequest request) {
		ErrorResponse message = new ErrorResponse(ex.getMessage());
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", message);
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorResponse message = new ErrorResponse(ex.getMessage());
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", message);
		body.put("global message", "Check the url");

		return new ResponseEntity<Object>(body, HttpStatus.BAD_GATEWAY);
	}
}
