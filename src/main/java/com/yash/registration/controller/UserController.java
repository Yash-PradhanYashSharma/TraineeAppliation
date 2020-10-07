package com.yash.registration.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.yash.registration.domain.User;
import com.yash.registration.service.*;

@RestController
@RequestMapping("/register/v1")
public class UserController {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;

    @Autowired
    private ValidationErrorService validationErrorService;

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
        ResponseEntity<?> errorMap = validationErrorService.mapValidationError(result);
        if (errorMap != null) {
            LOGGER.info("USER NOT CREATED");
            return errorMap;
            }
        User newUser = userService.saveUser(user);
        LOGGER.info(user.toString() + " is Created");
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        Optional<User> user = userService.findUserById(userId);
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        }

    @DeleteMapping("/users")
    public String deleteAllUsers() {
        return userService.deleteAll();
        }

    @DeleteMapping("/users/{userId}")
    public String deleteUserById(@PathVariable Long userId) {
        return userService.deleteUserById(userId);
        }

    @PutMapping("/users/{userId}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long userId) {

        Optional<User> user = userService.findUserById(userId);
        if (user.isPresent()) {
            User editedUser = user.get();
            editedUser.setUsername(newUser.getUsername());
            editedUser.setFullname(newUser.getFullname());
            editedUser.setPassword(newUser.getPassword());
            editedUser.setCreated_at(newUser.getCreated_at());
            return userService.saveUser(editedUser);
        } else {
            newUser.setId(userId);
            return userService.saveUser(newUser);
        }
    }    
}
