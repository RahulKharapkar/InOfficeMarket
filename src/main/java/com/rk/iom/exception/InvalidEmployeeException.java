package com.rk.iom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidEmployeeException extends Exception{


	public InvalidEmployeeException(String string) {
		// TODO Auto-generated constructor stub
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String InvalidEmployeeException(InvalidEmployeeException ex) {
	    return ex.getMessage();
	  }
}
