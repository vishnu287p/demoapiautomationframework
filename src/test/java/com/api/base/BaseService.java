package com.api.base;

import static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
//wrapper class for rest assured
//BaseUri, Creating the REQUEST, Handling the RESPONSE

	
	private static final String Base_URL = "https://reqres.in/";
	private RequestSpecification requestspecification;

	public BaseService() {
		requestspecification = given().baseUri(Base_URL);
	}

	protected Response postRequest(Object payload, String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response getRequest(String endpoint) {
		return requestspecification.get(endpoint);
	}

	protected Response putRequest(Object payload, String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
}
