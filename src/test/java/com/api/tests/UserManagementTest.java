package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserManagementService;
import com.api.filters.LoggingFilter;
import com.api.models.request.UpdateRequest;
import com.api.models.response.UpdateResponse;
import com.api.models.response.GetSingleUserResponse;

import io.restassured.response.Response;

public class UserManagementTest extends LoggingFilter {
	@Test
	public void getSingleUser() {
		logger.info("*****getSingleUser TestCase Started *****");
		UserManagementService userManagementService = new UserManagementService();
		Response response = userManagementService.getSingleUser();
		GetSingleUserResponse getSingleUserResponse = response.as(GetSingleUserResponse.class);
		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200, "Status Code Mismatch!");
		Assert.assertEquals(getSingleUserResponse.getData().getEmail(), "janet.weaver@reqres.in", "Email mismatch!");
		logger.info("*****getSingleUser TestCase Finished *****");
	}

	@Test
	public void updateSingleUser() {
		logger.info("*****updateSingleUser TestCase Started *****");
		UpdateRequest updateRequest = new UpdateRequest.Builder().name("morpheus").job("zion resident").build();
		UserManagementService userManagementService = new UserManagementService();
		Response response = userManagementService.updateSingleUser(updateRequest);
		UpdateResponse updateResponse = response.as(UpdateResponse.class);

		System.out.println(response.asPrettyString());
		System.out.println(updateResponse.getName());

		Assert.assertEquals(response.getStatusCode(), 200, "Status Code Mismatch!");
		Assert.assertEquals(updateResponse.getJob(), "zion resident", "Job Mismatch!");
		logger.info("*****updateSingleUser TestCase Finished *****");
	}

	@Test
	public void deleteSingleUser() {
		logger.info("*****deleteSingleUser TestCase Started *****");
		UserManagementService userManagementService = new UserManagementService();
		Response response = userManagementService.deleteSingerUser();

		System.out.println(response.getStatusCode());

		Assert.assertEquals(response.getStatusCode(), 204, "Status Code Mismatch!");
		logger.info("*****deleteSingleUser TestCase Finished *****");
	}
}
