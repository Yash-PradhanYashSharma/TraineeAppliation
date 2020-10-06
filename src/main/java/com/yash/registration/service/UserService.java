package com.yash.registration.service;

import java.util.Optional;

import com.yash.registration.domain.User;

/**
 * This is the service class that has all user related services and will
 * interact with Repository layer to perform CRUD operations
 * 
 * @author husain.m
 *
 */

public interface UserService {
	
	/**
	 * This method will interact with the Repository layer and will persist new user
	 * 
	 * @param newUser
	 * @return
	 */
	User saveUser(User newUser);
	
	/**
	 * This method returns all the user registered
	 * @return List of users
	 */
	Iterable<User> findAllUsers();

	/**
	 * This method will find a single user by its id
	 * @param id
	 * @return Optional<User>
	 */
	Optional<User> findUserById(Long id);
	
	/**
	 * This method will delete all users in the database
	 * @return a string statement confirming deletion
	 */
	String deleteAll();
	
	/**
	 * This method will delete a single user according to the id provided
	 * @param id is the user id of user to be deleted
	 * @return a a string statement confirming deletion
	 */
	String deleteUserById(Long id);
	
	
}