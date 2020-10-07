package com.yash.registration.exception;

/**
 * This is the Response class for UserIdException to format the exception
 * message. By help of this class we can provide the exception message under the
 * id field.
 * 
 * @author husain.m
 *
 */
public class UserIdExceptionResponse {

    private String id;

    public UserIdExceptionResponse(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
