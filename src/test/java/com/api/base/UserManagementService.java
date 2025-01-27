package com.api.base;

import io.restassured.response.Response;

public class UserManagementService extends BaseService{

	private static final String BASE_PATH = "/api/users";
	
	public Response getSingleUser() {
		return getRequest(BASE_PATH+"/2");
	}
}
