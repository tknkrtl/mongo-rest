package com.atakan.mongoRest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.atakan.mongoRest.error.ErrorResponse;
import com.atakan.mongoRest.error.BindingResultException;
import com.atakan.mongoRest.error.DocumentNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(BindingResultException exc){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleNotFoundException(DocumentNotFoundException exc){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}

	
	
}
