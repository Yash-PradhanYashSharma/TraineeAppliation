package com.yash.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public final ResponseEntity<Object> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex
			) {
		UsernameAlreadyExistsExceptionResponse exceptionResponse = new UsernameAlreadyExistsExceptionResponse(
				ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

	}

}
