package com.yash.registration.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.registration.domain.User;
import com.yash.registration.service.UserService;
import com.yash.registration.service.ValidationErrorService;

@RestController
@CrossOrigin
@RequestMapping("")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private ValidationErrorService validationErrorService;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
		ResponseEntity<?> errorMap = validationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		User newUser = userService.saveUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

}
