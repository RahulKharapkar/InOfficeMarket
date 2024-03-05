package com.rk.iom.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rk.iom.exception.InvalidRequirementException;

@RestControllerAdvice
public class InvalidRequirementAdvice {
	
	@ExceptionHandler(InvalidRequirementException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String InvalidRequirementHandler(InvalidRequirementException ex) {
		return ex.getMessage();
	}
	
	

}
