package com.api.webApiTest.helper;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.api.webApiTest.model.RestResponse;

public class RestApiHelper {

	public static RestResponse performGetRequest(String url) {
		HttpGet get = new HttpGet(url);
		try(CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(get)) {
			ResponseHandler<String> body = new BasicResponseHandler();
			return new RestResponse(response.getStatusLine().getStatusCode(), body.handleResponse(response));

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		
	}
}
