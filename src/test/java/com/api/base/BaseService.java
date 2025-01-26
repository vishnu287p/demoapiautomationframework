package com.api.base;

import static io.restassured.RestAssured.*;

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
 
 protected Response postRequest(String payload, String endpoint) {
	 return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
 }
}
