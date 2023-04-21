package runner;
import api.APIClient;
import config.AppConfig;
import config.AuthorizationManager;
import config.EnvironmentManager;
import config.TestEnvironment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.RequestBuilder;
import utils.ResponsePayload;
import utils.ResponseValidator;

public class UserManagementAPISteps {

    private final TestEnvironment testEnvironment;
    private final APIClient apiClient;
    private final AuthorizationManager authManager;
    private final RequestBuilder requestBuilder;
    private final ResponseValidator responseValidator;
    private ResponsePayload response;

    public UserManagementAPISteps(TestEnvironment testEnvironment) {
        this.testEnvironment = testEnvironment;
        this.apiClient = new APIClient(testEnvironment);
        this.authManager = new AuthorizationManager(testEnvironment);
        this.requestBuilder = new RequestBuilder();
        this.responseValidator = new ResponseValidator();
    }

    @Given("^a request header of \"([^\"]*)\"$")
    public void setRequestHeader(String headerValue) {
    }

    @When("^a GET request is made to \"([^\"]*)\"$")
    public void sendGetRequest(String endpoint) {
        String url = testEnvironment.getBaseUrl() + endpoint;
        apiClient.setAuthorization(authManager.getAuthorizationHeader());
        response = apiClient.get(url, requestBuilder.build());
    }

    @When("^a POST request is made to \"([^\"]*)\" with the user object$")
    public void sendPostRequest(String endpoint, RequestPayload userObject) {
        String url = testEnvironment.getBaseUrl() + endpoint;
        apiClient.setAuthorization(authManager.getAuthorizationHeader());
        response = apiClient.post(url, requestBuilder.build(), userObject);
    }

    @When("^a PUT request is made to \"([^\"]*)\" with the updated user object$")
    public void sendPutRequest(String endpoint, RequestPayload userObject) {
        String url = testEnvironment.getBaseUrl() + endpoint;
        apiClient.setAuthorization(authManager.getAuthorizationHeader());
        response = apiClient.put(url, requestBuilder.build(), userObject);
    }

    @When("^a DELETE request is made to \"([^\"]*)\"$")
    public void sendDeleteRequest(String endpoint) {
        String url = testEnvironment.getBaseUrl() + endpoint;
        apiClient.setAuthorization(authManager.getAuthorizationHeader());
        response = apiClient.delete(url, requestBuilder.build());
    }

    @When("^a PATCH request is made to \"([^\"]*)\" with the partial user object$")
    public void sendPatchRequest(String endpoint, RequestPayload partialUserObject) {
        String url = testEnvironment.getBaseUrl() + endpoint;
        apiClient.setAuthorization(authManager.getAuthorizationHeader());
        response = apiClient.patch(url, requestBuilder.build(), partialUserObject);
    }

    @Then("^the response status code should be (\\d+)$")
    public void validateResponseStatusCode(int expectedStatusCode) {
        responseValidator.validateStatusCode(response, expectedStatusCode);
    }

    @Then("^the response body should be a list of users$")
    public void validateResponseBodyIsListOfUsers() {
        responseValidator.validateResponseBodyIsListOfUsers(response);
    }

    @Then("^the response body should be the user object with ID (\\d+)$")
    public void validateResponseBodyIsUserObjectWithID(int userID) {
        responseValidator.validateResponseBodyIsUserObjectWithID(response, userID);
    }

    @Then("^the response body should be an error message$")
    public void validateResponseBodyIsErrorMessage() {
        responseValidator.validateResponseBodyIsErrorMessage(response);
    }

    @Then("^the response body should be
