package com.rk.iom.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rk.iom.exception.InvalidEmployeeException;

@RestControllerAdvice
public class InvalidEmployeeAdvice {
	

	@ExceptionHandler(InvalidEmployeeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String InvalidEmployeeHandler(InvalidEmployeeException ex) {
	    return ex.getMessage();
	  }
	
	

}
