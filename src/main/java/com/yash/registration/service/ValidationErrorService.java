package com.yash.registration.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface ValidationErrorService {

    /**
     * This method helps in mapping all the errors under their respective field
     * names, so that we can provide the errors in JSON format under their
     * respective field names.
     * 
     * @param result - is instance of BindingResult that binds all errors together.
     * @return - an instance of ResponseEntity with errors and status code.
     */
    ResponseEntity<?> mapValidationError(BindingResult result);

}
