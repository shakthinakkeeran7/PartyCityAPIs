package api;

import org.junit.Test;

import api.APIClient;
import config.AuthorizationManager;
import config.TestEnvironment;
import model.ResponsePayload;

import api.APIClient;
import config.AppConfig;
import config.AuthorizationManager;
import config.EnvironmentManager;
import config.TestEnvironment;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class TestAPI {

	public final TestEnvironment testEnvironment;
	public final APIClient apiClient;
	public final AuthorizationManager authManager;
	public final api.RequestBuilder requestBuilder;
	public final ResponseValidator responseValidator;
	public ResponsePayload response;

	public TestAPI(TestEnvironment testEnvironment) {
		this.testEnvironment = testEnvironment;
		this.apiClient = new APIClient(testEnvironment);
		this.authManager = new AuthorizationManager(testEnvironment);
		this.requestBuilder = new RequestBuilder(authManager);
		this.responseValidator = new ResponseValidator();
	}

	@org.testng.annotations.Test(priority = 1)
	public void a_request_header_of(String string) {
		System.out.println();
		String[] parts = "Content-Type: application/json".split(": ");
		String name = parts[0];
		String value = parts[1];
		requestBuilder.withHeader(name, value);
	}

	@org.testng.annotations.Test(priority = 2)
	public void a_get_request_is_made_to(String endpoint) {
		String url = testEnvironment.getBaseUrl() + "/users";

		apiClient.setAuthorization(authManager);

		Response response = apiClient.sendGetRequest(url, null, null);
		System.out.println(response.asString());

	}

}
