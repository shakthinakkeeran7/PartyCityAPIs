
package test;

import java.util.Map;

import org.testng.annotations.Test;

import api.APIClient;
import api.Endpoints;

import api.RequestBuilder;
import api.ResponseValidator;
import config.AuthorizationManager;
import config.TestEnvironment;
import api.APIClient;
import config.AppConfig;
import config.AuthorizationManager;
import config.EnvironmentManager;
import config.TestEnvironment;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import utils.ResponsePayload;
import utils.TestContext;

public class TestAPIs {

	
	    private final APIClient apiClient;
	    private final AuthorizationManager authManager;
	    private final ResponseValidator responseValidator;
	    private ResponsePayload response;
	    
		TestContext testContext;
	    
	public static Endpoints endpoints = new Endpoints();
	public static TestEnvironment testEnvironment = new TestEnvironment(endpoints.BASE_URL, null);
	private static RequestBuilder requestBuilder = new RequestBuilder(null);

	public TestAPIs() {
		   this.testEnvironment = testEnvironment;
	        this.apiClient = new APIClient(testEnvironment);
	        this.authManager = new AuthorizationManager(testEnvironment);
	        this.responseValidator = new ResponseValidator();
		}
	@Test
	private void test1() {
		a_request_header_of("Content-Type: application/json");
		a_get_request_is_made_to("/users");

	}
	public void a_request_header_of(String string) {

		String[] parts = string.split(": ");
		String name = parts[0];
		String value = parts[1];
		requestBuilder.withHeader(name, value);
		
		
	}
	public void a_get_request_is_made_to(String endpoint) {

		String url = testEnvironment.getBaseUrl() + endpoint;
		System.out.println(url);
		Response sendGet = apiClient.sendGet(url, requestBuilder.getHeaders());
		
		System.out.println(sendGet.asString());
	}
}