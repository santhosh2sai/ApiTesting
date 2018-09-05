package com.api.webApiTest;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.api.webApiTest.helper.RestApiHelper;
import com.api.webApiTest.model.RestResponse;

public class GetMethodTest {
	
	@Test
	public void testGetPingAlive() {
		String url = "http://localhost:8080/laptop-bag/webapi/api/ping/helloworld";
		RestResponse response = RestApiHelper.performGetRequest(url);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Assert.assertEquals("Hi! helloworld", response.getResponseBody());
	}
}
