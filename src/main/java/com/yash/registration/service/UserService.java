package com.yash.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.registration.domain.User;
import com.yash.registration.repository.UserRepository;

/**
 * This is the service class that has all user related services and will
 * interact with Repository layer to perform CRUD operations
 * 
 * @author husain.m
 *
 */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	/**
	 * This method will interact with the Repository layer and will persist new user
	 * 
	 * @param newUser
	 * @return
	 */
	public User saveUser(User newUser) {
		return userRepository.save(newUser);
	}

}
