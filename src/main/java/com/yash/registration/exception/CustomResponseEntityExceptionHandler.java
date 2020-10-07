package com.yash.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<?> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex) {
        UsernameAlreadyExistsExceptionResponse exceptionResponse = new UsernameAlreadyExistsExceptionResponse(
                ex.getMessage());
        return new ResponseEntity<UsernameAlreadyExistsExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<?> handleUserIdException(UserIdException ex) {
        UserIdExceptionResponse exceptionResponse = new UserIdExceptionResponse(ex.getMessage());
        return new ResponseEntity<UserIdExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
