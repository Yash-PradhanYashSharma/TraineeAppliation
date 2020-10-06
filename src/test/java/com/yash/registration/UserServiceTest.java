package com.yash.registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.registration.domain.User;
import com.yash.registration.exception.UsernameAlreadyExistsException;
import com.yash.registration.service.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;

	@org.junit.Test(expected = UsernameAlreadyExistsException.class)
	void userServiceTest_GivenDuplicateUsername_ShouldThrowException() {
		User user = new User(0l, "bob_duplicate@gmail.com", "Bob Blob", "1234567890", new Date());
		userService.saveUser(user);
		userService.saveUser(user);
		userService.deleteAll();
	}

	@Test
	void deleteUserById_GivenUserId_ShouldRetunTrue() {
		User user = new User(0l, "bobdel@gmail.com", "Bob Blob", "1234567890", new Date());
		userService.saveUser(user);
		userService.deleteUserById(4l);
		Optional<User> userTest = userService.findUserById(4l);
		assertEquals(false, userTest.isPresent());
		userService.deleteAll();
	}

	@Test
	void findUserById_GivenUserId_ShouldReturnUser() {
		User user = new User(0l, "bob3333@gmail.com", "Bob Blob", "1234567890", new Date());
		userService.saveUser(user);
		Optional<User> userTest = userService.findUserById(5l);
		assertEquals(user.getUsername(), userTest.get().getUsername());
		userService.deleteAll();
	}

	@Test
	void saveUser_GivenUserDetails_ShouldPass() {
		User user = new User(0l, "bob_blob@gmail.com", "Bob Blob", "1234567890", new Date());
		User testUser = userService.saveUser(user);
		assertEquals(user.getUsername(), testUser.getUsername());
		userService.deleteAll();
	}

	@Test
	void findAllUsers_GivenVoid_ShouldPass() {
		User user = new User(0l, "bob@gmail.com", "Bob Blob", "1234567890", new Date());
		User user1 = new User(0l, "bob1@gmail.com", "Bob Blob", "1234567890", new Date());
		userService.saveUser(user);
		userService.saveUser(user1);
		List<User> list = (List<User>) userService.findAllUsers();
		assertEquals(2, list.size());
		userService.deleteAll();
	}

	@Test
	void deleteAll_GivenVoid_ShouldReturnTrue() {
		User user = new User(0l, "bob4@gmail.com", "Bob Blob", "1234567890", new Date());
		userService.saveUser(user);
		userService.deleteAll();
		List<User> list = (List<User>) userService.findAllUsers();
		assertEquals(0, list.size());
		userService.deleteAll();
	}

}
