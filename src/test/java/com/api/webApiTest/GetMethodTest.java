package com.api.webApiTest;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.api.webApiTest.helper.RestApiHelper;
import com.api.webApiTest.model.CountryBody;
import com.api.webApiTest.model.ResponseBody;
import com.api.webApiTest.model.RestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GetMethodTest {
	
	@Test
	public void testGetPingAlive() {
		String url = "http://localhost:8080/laptop-bag/webapi/api/ping/helloworld";
		RestResponse response = RestApiHelper.performGetRequest(url,null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Assert.assertEquals("Hi! helloworld", response.getResponseBody());
		System.out.println(response.getResponseBody());
	}
	
	@Test
	public void testGetAll() {
		String url = "http://localhost:8080/laptop-bag/webapi/api/all";
		Map<String,String> headers  =  new HashMap<String,String>();
		headers.put("Accept","application/json");
		RestResponse response = RestApiHelper.performGetRequest(url,headers);
		Assert.assertTrue("Expected Status code not found",(HttpStatus.SC_OK == response.getStatusCode() || HttpStatus.SC_NO_CONTENT == response.getStatusCode() ));
		System.out.println(response.getResponseBody());

	}
	
	@Test
	public void testGetFindWithId() {
		String url = "http://localhost:8080/laptop-bag/webapi/api/find/709";
		Map<String,String> headers  =  new HashMap<String,String>();
		headers.put("Accept","application/json");
		RestResponse response = RestApiHelper.performGetRequest(url,headers);
		Assert.assertTrue("Expected Status code not found",(HttpStatus.SC_OK == response.getStatusCode() || HttpStatus.SC_NOT_FOUND == response.getStatusCode() ));
		System.out.println(response.getResponseBody());

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body = gson.fromJson(response.getResponseBody(), ResponseBody.class);
		System.out.println(body.BrandName);
	}
	
}
