package com.api.webApiTest.helper;

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
		RestResponse response = RestApiHelper.performGetRequest("http://localhost:8080/laptop-bag/webapi/api/ping/sais");
		System.out.println(response.toString());
	}

}
