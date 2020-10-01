package com.yash.registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.registration.domain.User;
import com.yash.registration.service.UserService;

@SpringBootTest
class RegistrationApplicationTests {

	public static final Logger LOGGER = LoggerFactory.getLogger(RegistrationApplicationTests.class);
	@Autowired
	private UserService userService;

	@Test
	void test_userServiceTest_GivenCorrectUserDetails_ShouldReturnUserAndPersistIt() {
		User user = new User(0l, "bob_blob@gmail.com", "Bob Blob", "1234567890", new Date());
		User testUser = userService.saveUser(user);
		assertEquals(user.getUsername(), testUser.getUsername());
	}

}
