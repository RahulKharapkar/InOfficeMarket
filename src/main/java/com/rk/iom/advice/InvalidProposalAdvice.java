package com.rk.iom.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rk.iom.exception.InvalidProposalException;

@RestControllerAdvice
public class InvalidProposalAdvice {

	@ExceptionHandler(InvalidProposalException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String InvalidProposalHandler(InvalidProposalException ex) {
	    return ex.getMessage();
	  }
	
}
