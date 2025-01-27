package com.api.models.response;

public class RegisterResponse {
	private int id;
	private String token;
	private String error;

	public RegisterResponse() {
	}

	public RegisterResponse(int id, String token, String error) {
		super();
		this.id = id;
		this.token = token;
		this.error = error;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "RegisterResponse [id=" + id + ", token=" + token + ", error=" + error + "]";
	}
}
