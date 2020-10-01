package com.yash.registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.yash.registration.domain.User;
import com.yash.registration.service.UserService;

public class UserControllerTest extends RestApiTest {
	@MockBean
	private UserService userService;

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void test_GivenAllCorrectUserInformation_ShouldReturnStatusCreated() throws Exception {
		String uri = "http://localhost:8080/register";
		User user = new User(0l, "bob_blob@gmai", "Bob Blob", "1234567890", new Date());
		String inputJson = super.mapToJson(user);
		System.out.println(inputJson);
		//TODO mvcResult is throwing null pointer exception
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		System.out.println(mvcResult);

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		// assertEquals(content, "Product is created successfully");
	}

}
