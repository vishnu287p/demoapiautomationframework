package com.api.models.response;

public class UpdateResponse {

	private String name;
	private String job;
	private String updatedAt;

	public UpdateResponse() {

	}

	public UpdateResponse(String name, String job, String updatedAt) {
		super();
		this.name = name;
		this.job = job;
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UpdateResponse [name=" + name + ", job=" + job + ", updatedAt=" + updatedAt + "]";
	}

}
