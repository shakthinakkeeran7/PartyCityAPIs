package StepDefinitions;

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
import utils.RequestBuilder;
import utils.ResponseValidator;

public class UserTestSteps {

	private final TestEnvironment testEnvironment;
	private final APIClient apiClient;
	private final AuthorizationManager authManager;
	private final api.RequestBuilder requestBuilder;
	private final ResponseValidator responseValidator;
	private ResponsePayload response;

	public UserTestSteps(TestEnvironment testEnvironment) {
		this.testEnvironment = testEnvironment;
		this.apiClient = new APIClient(testEnvironment);
		this.authManager = new AuthorizationManager(testEnvironment);
		this.requestBuilder = new RequestBuilder();
		this.responseValidator = new ResponseValidator();
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
		
		apiClient.setAuthorization(authManager);
		response = apiClient.get(url, requestBuilder.build());
		
		Response response = apiClient.sendGetRequest(url, null, null);

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be a list of users")
	public void the_response_body_should_be_a_list_of_users() {

	

	}

	@Given("a user with an ID of {int} exists in the database")
	public void a_user_with_an_id_of_exists_in_the_database(Integer int1) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be the user object with ID {int}")
	public void the_response_body_should_be_the_user_object_with_id(Integer int1) {

	

	}

	@Given("no user with an ID of {int} exists in the database")
	public void no_user_with_an_id_of_exists_in_the_database(Integer int1) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be an error message")
	public void the_response_body_should_be_an_error_message() {

	

	}

	@Given("a user object with name {string} and email {string}")
	public void a_user_object_with_name_and_email(String string, String string2) {

	}

	@When("a POST request is made to {string} with the user object")
	public void a_post_request_is_made_to_with_the_user_object(String string) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be the newly created user object")
	public void the_response_body_should_be_the_newly_created_user_object() {

	

	}

	@Given("a user with an ID of {int} exists in the database")
	public void a_user_with_an_id_of_exists_in_the_database(Integer int1) {

	}

	@Given("a user object with name {string} and email {string}")
	public void a_user_object_with_name_and_email(String string, String string2) {

	}

	@When("a PUT request is made to {string} with the updated user object")
	public void a_put_request_is_made_to_with_the_updated_user_object(String string) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be the updated user object")
	public void the_response_body_should_be_the_updated_user_object() {

	}

	

	@Given("no user with an ID of {int} exists in the database")
	public void no_user_with_an_id_of_exists_in_the_database(Integer int1) {

	}

	@Given("a user object with name {string} and email {string}")
	public void a_user_object_with_name_and_email(String string, String string2) {

	}

	@When("a PUT request is made to {string} with the updated user object")
	public void a_put_request_is_made_to_with_the_updated_user_object(String string) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be an error message")
	public void the_response_body_should_be_an_error_message() {

	

	}

	@Given("a user with an ID of {int} exists in the database")
	public void a_user_with_an_id_of_exists_in_the_database(Integer int1) {

	}

	@When("a DELETE request is made to {string}")
	public void a_delete_request_is_made_to(String string) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be empty")
	public void the_response_body_should_be_empty() {

	}

	@Then("the user with ID {int} should no longer exist in the database")
	public void the_user_with_id_should_no_longer_exist_in_the_database(Integer int1) {

	

	}

	@Given("no user with an ID of {int} exists in the database")
	public void no_user_with_an_id_of_exists_in_the_database(Integer int1) {

	}

	@When("a DELETE request is made to {string}")
	public void a_delete_request_is_made_to(String string) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be an error message")
	public void the_response_body_should_be_an_error_message() {

	

	}

	@Given("a user with an ID of {int} exists in the database")
	public void a_user_with_an_id_of_exists_in_the_database(Integer int1) {

	}

	@Given("a partial user object with name {string}")
	public void a_partial_user_object_with_name(String string) {

	}

	@When("a PATCH request is made to {string} with the partial user object")
	public void a_patch_request_is_made_to_with_the_partial_user_object(String string) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be the updated user object with name {string}")
	public void the_response_body_should_be_the_updated_user_object_with_name(String string) {

	}

	

	@Given("no user with an ID of {int} exists in the database")
	public void no_user_with_an_id_of_exists_in_the_database(Integer int1) {

	}

	@Given("a partial user object with name {string}")
	public void a_partial_user_object_with_name(String string) {

	}

	@When("a PATCH request is made to {string} with the partial user object")
	public void a_patch_request_is_made_to_with_the_partial_user_object(String string) {

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {

	}

	@Then("the response body should be an error message")
	public void the_response_body_should_be_an_error_message() {

	}

}
