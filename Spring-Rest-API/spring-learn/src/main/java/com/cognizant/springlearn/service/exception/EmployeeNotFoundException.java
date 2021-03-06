package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class EmployeeNotFoundException extends Exception{
	
	private static final long serialVersionUID = -4082202135031453776L;

}
