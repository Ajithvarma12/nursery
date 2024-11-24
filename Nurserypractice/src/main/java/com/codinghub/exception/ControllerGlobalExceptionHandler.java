package com.codinghub.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerGlobalExceptionHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	public String handleDataNotFoundException(DataNotFoundException ex) {
		String errorResult = ex.getErrorCode() + ": " + ex.getErrorMessage();
		return errorResult;
	}
	
}
