package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class LoginTest {

	@Test
	public void testUserLogin() {

		LoginRequest loginrequest = new LoginRequest("eve.holt@reqres.in", "cityslicka");
		AuthService authService = new AuthService();
		Response response = authService.login(loginrequest);
		LoginResponse loginresponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginresponse.getToken());

		Assert.assertTrue(loginresponse.getToken() != null);
	}

	@Test
	public void testInvalidUserLogin() {
		LoginRequest loginerequest = new LoginRequest("peter@klaven", " ");
		AuthService authService = new AuthService();
		Response response = authService.login(loginerequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);

		Assert.assertEquals(response.getStatusCode(), 400, "Expected status code 400 for invalid login!");
		System.out.println(loginResponse.getError());
		Assert.assertEquals(loginResponse.getError(), "Missing password", "Error message mismatch!");

	}

}
