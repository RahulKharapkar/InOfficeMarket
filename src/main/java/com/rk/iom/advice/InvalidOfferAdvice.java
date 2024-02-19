package com.rk.iom.advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rk.iom.exception.InvalidOfferException;

@RestControllerAdvice
public class InvalidOfferAdvice {
	
	@ExceptionHandler(InvalidOfferException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String InvalidOfferHandler(InvalidOfferException ex) {
	    return ex.getMessage();
	  }

}
