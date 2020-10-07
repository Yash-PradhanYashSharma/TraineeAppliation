package com.yash.registration.service;

import java.util.Optional;

import com.yash.registration.domain.User;

/**
 * This is the service class that has all user related services and will
 * interact with Repository layer to perform CRUD operations.We can save user,
 * find user, find all users, delete user, delete all users.
 * 
 * @author husain.m
 *
 */

public interface UserService {

    /**
     * This method will interact with the Repository layer and will persist new
     * user. Also it can update a user if id is provided
     * 
     * @param - newUser is the user to be persisted or updated
     * @return - an instance of user created or updated.
     */
    User saveUser(User newUser);

    /**
     * This method returns all the user registered in the database.
     * 
     * @return - List of users.
     */
    Iterable<User> findAllUsers();

    /**
     * This method will find a single user by the provided id.
     * 
     * @param - id is the unique identity by which user is found in database
     * @return - Optional<User> we may or we may not get the instance of the user.
     */
    Optional<User> findUserById(Long id);

    /**
     * This method will delete all users in the database
     * 
     * @return - a string statement confirming deletion
     */
    String deleteAll();

    /**
     * This method will delete a single user according to the id provided
     * 
     * @param - id is the user id of user to be deleted
     * @return - a string statement confirming deletion
     */
    String deleteUserById(Long id);

}