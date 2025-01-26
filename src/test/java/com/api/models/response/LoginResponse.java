package com.api.models.response;

public class LoginResponse {
private String token;

public LoginResponse() {
	
}
public LoginResponse(String token) {
	super();
	this.token = token;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

@Override
public String toString() {
	return "LoginResponse [token=" + token + "]";
}

}
