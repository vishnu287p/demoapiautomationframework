package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.filters.LoggingFilter;
import com.api.models.request.RegisterRequest;
import com.api.models.response.RegisterResponse;

import io.restassured.response.Response;

public class RegisterTest extends LoggingFilter{
	@Test
	public void testUserRegistration() {
		logger.info("*****Valid Registration Test Case Started *****");
		RegisterRequest registerRequest = new RegisterRequest.Builder().email("eve.holt@reqres.in").password("pistol").build();

		AuthService authService = new AuthService();
		Response response = authService.Register(registerRequest);
		RegisterResponse registerResponse = response.as(RegisterResponse.class);

		System.out.println(response.asPrettyString());
		System.out.println(registerResponse.getId());

		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
		Assert.assertNotNull(registerResponse.getId(), "Registration ID is null!");
		
		logger.info("*****Valid Registration Test Case Finished *****");
	}

	@Test
	public void testUserInvalidRegistration() {
		logger.info("*****InValid Registration Test Case Started *****");
		RegisterRequest registerRequest = new RegisterRequest.Builder().email("sydney@fife").build();

		AuthService authService = new AuthService();
		Response response = authService.Register(registerRequest);
		RegisterResponse registerResponse = response.as(RegisterResponse.class);

		Assert.assertEquals(response.getStatusCode(), 400, "Status code mismatch!");
		System.out.println(registerResponse.getError());
		Assert.assertTrue(registerResponse.getError().equals("Missing password"), "Expected error message not found!");
		logger.info("*****InValid Registration Test Case Finished *****");
	}
}
