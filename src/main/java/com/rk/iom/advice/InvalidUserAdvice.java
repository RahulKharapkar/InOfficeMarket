package com.rk.iom.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rk.iom.exception.InvalidUserException;

@RestControllerAdvice
public class InvalidUserAdvice {
	
	@ExceptionHandler(InvalidUserException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String InvalidUserHandler(InvalidUserException ex) {
		return ex.getMessage();
	}
	
	

}
