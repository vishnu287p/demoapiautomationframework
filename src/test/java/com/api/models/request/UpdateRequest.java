package com.api.models.request;

public class UpdateRequest {
	private String name;
	private String job;

	public UpdateRequest(String name, String job) {
		super();
		this.name = name;
		this.job = job;
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

	@Override
	public String toString() {
		return "UpdateRequest [name=" + name + ", job=" + job + "]";
	}

	public static class Builder {
		private String name;
		private String job;

		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder job(String job) {
			this.job = job;
			return this;
		}
		public UpdateRequest build() {
			UpdateRequest updateRequest = new UpdateRequest(name, job);
			return updateRequest;
		}
	}
}
