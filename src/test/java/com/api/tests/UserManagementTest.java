package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserManagementService;
import com.api.models.request.UpdateRequest;
import com.api.models.response.UpdateResponse;
import com.api.models.response.GetSingleUserResponse;

import io.restassured.response.Response;

public class UserManagementTest {
	@Test
	public void getSingleUser() {
		UserManagementService userManagementService = new UserManagementService();
		Response response = userManagementService.getSingleUser();
		GetSingleUserResponse getSingleUserResponse = response.as(GetSingleUserResponse.class);
		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200, "Status Code Mismatch!");
		Assert.assertEquals(getSingleUserResponse.getData().getEmail(), "janet.weaver@reqres.in", "Email mismatch!");
	}

	@Test
	public void updateSingleUser() {
		UpdateRequest updateRequest = new UpdateRequest.Builder().name("morpheus").job("zion resident").build();
		UserManagementService userManagementService = new UserManagementService();
		Response response = userManagementService.updateSingleUser(updateRequest);
		UpdateResponse updateResponse = response.as(UpdateResponse.class);

		System.out.println(response.asPrettyString());
		System.out.println(updateResponse.getName());

		Assert.assertEquals(response.getStatusCode(), 200, "Status Code Mismatch!");
		Assert.assertEquals(updateResponse.getJob(), "zion resident", "Job Mismatch!");

	}
}
