package StepDefinitions;

import org.testng.Assert;

import api.APIClient;
import api.Endpoints;

import api.RequestBuilder;
import api.ResponseValidator;
import config.AuthorizationManager;
import config.TestEnvironment;
import utils.ResponsePayload;
import utils.TestContext;
import api.APIClient;
import config.AppConfig;
import config.AuthorizationManager;
import config.EnvironmentManager;
import config.TestEnvironment;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class UserTestSteps {
	public static Endpoints endpoints = new Endpoints();
	public static TestEnvironment testEnvironment = new TestEnvironment(endpoints.BASE_URL, null);
	private static RequestBuilder requestBuilder = new RequestBuilder(null);
	private APIClient apiClient;
	TestContext testContext;
    private final ResponseValidator responseValidator= new ResponseValidator();
    private ResponsePayload response;

	public UserTestSteps() {
		this.apiClient = new APIClient(testEnvironment);
		testContext = new TestContext();
	}

	@Given("a request header of {string}")
	public void a_request_header_of(String string) {
		String[] parts = string.split(": ");
		String name = parts[0];
		String value = parts[1];
		requestBuilder.withHeader(name, value);

	}

	@When("a GET request is made to {string}")
	public void a_get_request_is_made_to(String endpoint) {

		String url = testEnvironment.getBaseUrl() + endpoint;
		Response sendGet = apiClient.sendGet(url, requestBuilder.getHeaders());
	
		response.setStatus(sendGet.statusCode());
		System.out.println(response.getStatus());
		

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer expectedStatusCode) {
		
		System.out.println(expectedStatusCode);
		System.out.println(response.getStatus());
		 Assert.assertEquals(response.getStatus(), expectedStatusCode, "Unexpected status code returned");
	}

	@Then("the response body should be a list of users")
	public void the_response_body_should_be_a_list_of_users() {
	}

	@Given("a user with an ID of {int} exists in the database")
	public void a_user_with_an_id_of_exists_in_the_database(Integer int1) {
	}

	@Then("the response body should be the user object with ID {int}")
	public void the_response_body_should_be_the_user_object_with_id(Integer int1) {
	}

}