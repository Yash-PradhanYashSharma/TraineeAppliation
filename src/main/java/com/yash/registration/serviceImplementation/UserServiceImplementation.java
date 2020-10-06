package com.yash.registration.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.registration.domain.User;
import com.yash.registration.exception.UsernameAlreadyExistsException;
import com.yash.registration.repository.UserRepository;
import com.yash.registration.service.UserService;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

@Service
public class UserServiceImplementation implements UserService {
	String traceEntry = "ENTRY";
    Marker traceEntryMarker = MarkerFactory.getMarker(traceEntry);
    String traceExit = "EXIT";
    Marker traceExitMarker = MarkerFactory.getMarker(traceExit);
	public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplementation.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User newUser) {
		LOGGER.info(traceEntryMarker, "Entered into saveUser Method");
		try {
			User user = userRepository.save(newUser);
			LOGGER.info("user persisted: " + user);
			LOGGER.info(traceExitMarker, "Exit from saveUser Method");
			return user;
		} catch (Exception e) {
			LOGGER.info(traceExitMarker, "Exit from saveUser Method");
			throw new UsernameAlreadyExistsException("Username '" + newUser.getUsername() + "' already Exists");
		}
	}

	@Override
	public Iterable<User> findAllUsers() {
		LOGGER.info(traceEntryMarker, "Entered into findAllUsers Method");
		LOGGER.info(traceExitMarker, "Exit from findAllUsers Method");
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(Long id) {
		LOGGER.info(traceEntryMarker, "Entered into findUserById Method");
		Optional<User> user = userRepository.findById(id);
		LOGGER.info(traceExitMarker, "Exit from findUserById Method");
		return user;
	}

	@Override
	public String deleteAll() {
		LOGGER.info(traceEntryMarker, "Entered into deleteAll Method");
		userRepository.deleteAll();
		LOGGER.info(traceEntryMarker, "Exit from deleteAll Method");
		return "Delete all performed successfully";
	}

	@Override
	public String deleteUserById(Long id) {
		LOGGER.info(traceEntryMarker, "Entered into deleteUserById Method");
		userRepository.deleteById(id);
		LOGGER.info(traceEntryMarker, "Exit from deleteUserById Method");
		return "User with id: "+id+" deleted succesfully";
	}

}
