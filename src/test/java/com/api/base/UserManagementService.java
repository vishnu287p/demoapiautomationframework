package com.api.base;

import com.api.models.request.UpdateRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService{

	private static final String BASE_PATH = "/api/users";
	
	public Response getSingleUser() {
		return getRequest(BASE_PATH+"/2");
	}
	
	public Response updateSingleUser(UpdateRequest payload) {
		return putRequest(payload, BASE_PATH+"/2");
	}
	
	public Response deleteSingerUser() {
		return deleteRequest(BASE_PATH+"/2");
	}
}
