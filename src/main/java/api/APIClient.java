package api;

import java.util.HashMap;
import java.util.Map;

import config.AuthorizationManager;
import config.TestEnvironment;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.ResponsePayload;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class APIClient {
	private TestEnvironment testEnvironment;

    

	private OkHttpClient httpClient;
	private RequestBuilder requestBuilder;

	private static final RestAssuredConfig CONFIG = RestAssured.config()
			.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

	public APIClient(TestEnvironment testEnvironment) {
        this.testEnvironment = testEnvironment;
    }

	public static Response sendGetRequest1(String endpoint, Map<String, String> headers, Map<String, ?> queryParams) {
		return RestAssured.given().config(CONFIG).headers(headers).queryParams(queryParams).get(endpoint).andReturn();
	}
	
	


	public static Response sendPostRequest(String endpoint, Map<String, String> headers, Object requestBody) {
		return RestAssured.given().config(CONFIG).headers(headers).contentType(ContentType.JSON).body(requestBody)
				.post(endpoint).andReturn();
	}

	public static Response sendPutRequest(String endpoint, Map<String, String> headers, Object requestBody) {
		return RestAssured.given().config(CONFIG).headers(headers).contentType(ContentType.JSON).body(requestBody)
				.put(endpoint).andReturn();
	}

	public static Response sendDeleteRequest(String endpoint, Map<String, String> headers) {
		return RestAssured.given().config(CONFIG).headers(headers).delete(endpoint).andReturn();
	}

	public static Map<String, String> getHeaders(Map<String, String> requestHeaders) {
		Map<String, String> headers = new HashMap<>(requestHeaders);
		// Add any additional common headers here
		return headers;

	}

	public void setRequestHeader(String string, String headerValue) {
		// TODO Auto-generated method stub

	}

	public void setAuthorization(AuthorizationManager authorizationManager) {
		String authorizationHeader = authorizationManager.getAuthorizationHeader();
		requestBuilder.withHeader("Authorization", authorizationHeader);
	}

	
	public static Response sendGet(String endpoint, Map<String, String> headers) {
		return RestAssured.given().config(CONFIG).headers(headers).get(endpoint).andReturn();
	}
	

}
