package com.yash.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yash.registration.service.UserService;

@SpringBootApplication
public class RegistrationApplication {
	@Autowired
	private static UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(RegistrationApplication.class, args);
//		User user = new User(101l,"bob_blob@gmail.com","Bob Blob", "1234567890",new Date());
//		userService.saveUser(user);

	}
//	@Bean
//    public CommandLineRunner run(UserService userService) throws Exception {
//        return (String[] args) -> {
//        	User user = new User(1l,"bob_blob@gmail.com","Bob Blob", "1234567890",new Date());
//        	userService.saveUser(user);
//        };
//    }

}
