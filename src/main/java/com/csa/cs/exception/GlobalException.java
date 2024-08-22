package com.csa.cs.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.csa.cs.response.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse> handleRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException ex) {
//		HttpStatus statusCode = HttpStatus.METHOD_NOT_ALLOWED;
		String message = ex.getMessage();
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
        .body(new ApiResponse(false, message, null));
//		ApiResponse response = new ApiResponse("405", message, null);
//		return ResponseEntity.status(statusCode).body(response);
	}

//	@ExceptionHandler({ DuplicateEntryException.class, SQLIntegrityConstraintViolationException.class })
//	public ResponseEntity<ApiResponse> handleDuplicateEntryException(Exception ex) {
//		HttpStatus statusCode = HttpStatus.CONFLICT;
//		String message = ex.getMessage();
//
//		ApiResponse response = new ApiResponse(false, message, null);
//		return ResponseEntity.status(statusCode).body(response);
//	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> handleException(Exception ex) {
		HttpStatus statusCode = HttpStatus.UNAUTHORIZED;
		String message = ex.getMessage();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
		        .body(new ApiResponse(false, message, null));
//		ApiResponse response = new ApiResponse("401", message, null);
//		return ResponseEntity.status(statusCode).body(response);
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseBody
	public ResponseEntity<ApiResponse> handleValidationException(ValidationException ex) {
		HttpStatus statusCode = HttpStatus.UNPROCESSABLE_ENTITY;
		String message = ex.getMessage();
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
		        .body(new ApiResponse(false, message, null));
//		ApiResponse response = new ApiResponse("422", message, null);
//		return ResponseEntity.status(statusCode).body(response);
	}
	
}