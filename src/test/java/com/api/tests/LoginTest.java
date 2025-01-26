package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class LoginTest {

	@Test
	public void loginTest() {
		LoginRequest loginrequest = new LoginRequest("eve.holt@reqres.in", "cityslicka");
		AuthService auth = new AuthService();
		Response response = auth.login(loginrequest);
		LoginResponse loginresponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());	
		System.out.println(loginresponse.getToken());
		
		Assert.assertTrue(loginresponse.getToken() != null);
	}
	
	
}
