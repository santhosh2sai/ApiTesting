package com.api.webApiTest.helper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.api.webApiTest.model.RestResponse;

public class RestApiHelper {

	public static RestResponse performGetRequest(String url, Map<String,String> headers) {
		try {
			return performGetRequest(new URI(url),headers);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	public static RestResponse performGetRequest(URI uri,Map<String,String> headers) {
		HttpGet get = new HttpGet(uri);

		if(headers != null ) {
			for(String s: headers.keySet()) {
				get.addHeader(s, headers.get(s));
			}
		}
		CloseableHttpResponse response = null;
		try (CloseableHttpClient client = HttpClientBuilder.create().build())
				 {
			response = client.execute(get);
			ResponseHandler<String> body = new BasicResponseHandler();
			return new RestResponse(response.getStatusLine().getStatusCode(), body.handleResponse(response));

		} catch (Exception e) {
			if(e instanceof HttpResponseException)
				return new RestResponse(response.getStatusLine().getStatusCode(), e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static RestResponse performPostRequest(String url,String content,Map<String,String> headers) {
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse response = null;
		if(headers != null ) {
			for(String s: headers.keySet()) {
				post.addHeader(s, headers.get(s));
			}
		}
		post.setEntity(new StringEntity(content, ContentType.APPLICATION_JSON));
		
		try (CloseableHttpClient client = HttpClientBuilder.create().build()){
					response = client.execute(post);
					ResponseHandler<String> body = new BasicResponseHandler();
					return new RestResponse(response.getStatusLine().getStatusCode(), body.handleResponse(response));
			
				 } catch (IOException e) {
					 if(e instanceof HttpResponseException)
							return new RestResponse(response.getStatusLine().getStatusCode(), "");
					throw new RuntimeException(e.getMessage(), e);
				}
		
	}
}
