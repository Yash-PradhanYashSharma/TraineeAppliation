package com.yash.registration.exception;

/**
 * This is the Response class for UsernameAlreadyExistsException to format the
 * exception message. By help of this class we can provide the exception message
 * under the username field.
 * 
 * @author husain.m
 *
 */
public class UsernameAlreadyExistsExceptionResponse {

    private String username;

    public UsernameAlreadyExistsExceptionResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
