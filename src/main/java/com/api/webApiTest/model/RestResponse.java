package com.api.webApiTest.model;

public class RestResponse {

	private int statusCode;
	public int getStatusCode() {
		return statusCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	private String responseBody;

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public RestResponse(int statusCode, String responseBody) {
		this.statusCode = statusCode;
		this.responseBody = responseBody;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Status Code : %1s Body : %2s", this.statusCode, this.responseBody);
	}

}
