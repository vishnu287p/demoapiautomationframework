package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class LoginTest {

	@Test
	public void loginTest() {

		AuthService auth = new AuthService();
		Response response = auth.login("{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}");
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}
