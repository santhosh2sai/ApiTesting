package com.api.webApiTest.helper;

import java.io.IOException;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.api.webApiTest.model.RestResponse;

public class GetRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	HttpGet get = new HttpGet("http://localhost:8080/laptop-bag/webapi/api/ping/sai");

		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(get)) {
			
			 * StatusLine status = response.getStatusLine();
			 * System.out.println(status.getStatusCode());
			 * System.out.println(status.getProtocolVersion());
			 

			ResponseHandler<String> body = new BasicResponseHandler();
			RestResponse restResponse = new RestResponse(response.getStatusLine().getStatusCode(),
					body.handleResponse(response));
			
			 * String getBody = body.handleResponse(response);
			  System.out.println(restResponse.toString());
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	/*	RestResponse response = RestApiHelper.performGetRequest("http://localhost:8080/laptop-bag/webapi/api/ping/sais",null);
		System.out.println(response.toString());*/
		String jsonBody = "{" +
				"\"BrandName\": \"Dell\"," +
				"\"Features\": {" +
					"\"Feature\": [\"8GB RAM\"," +
					"\"1TB Hard Drive\"]"+
				"}," +
				"\"Id\": " + (int)(1000*(Math.random())) + "," +
				"\"LaptopName\": \"Latitude\"" +
			"}";
		
		HttpPost post = new HttpPost("http://localhost:8080/laptop-bag/webapi/api/add");
		try(CloseableHttpClient client = HttpClientBuilder.create().build()){
		post.addHeader("Content-Type","application/json");
		post.addHeader("Accept","application/json");
		StringEntity data = new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
		post.setEntity(data);
		CloseableHttpResponse response = client.execute(post);
		ResponseHandler<String> handler = new BasicResponseHandler();
		RestResponse restResponse = new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response));
		System.out.println(restResponse.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
