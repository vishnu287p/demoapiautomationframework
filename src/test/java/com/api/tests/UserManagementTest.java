package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserManagementService;
import com.api.models.response.UserManagementResponse;

import io.restassured.response.Response;

public class UserManagementTest {
	@Test
	public void getSingleUser() {
		UserManagementService userManagementService = new UserManagementService();
		Response response = userManagementService.getSingleUser();
		UserManagementResponse userManagementResponse = response.as(UserManagementResponse.class);
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200, "Status Code Mismatch!");
		Assert.assertEquals(userManagementResponse.getData().getEmail(), "janet.weaver@reqres.in", "Email mismatch!");
	}
}
