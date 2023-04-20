package StepDefinitions;

import io.restassured.response.Response;
import org.testng.Assert;

import com.example.framework.api.APIClient;
import com.example.framework.api.RequestBuilder;
import com.example.framework.api.ResponseValidator;
import com.example.framework.api.Endpoints;
import com.example.framework.constants.Constants;
import com.example.framework.models.RequestPayload;
import com.example.framework.models.ResponsePayload;
import com.example.framework.utils.TestDataGenerator;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyAPITestSteps {

    private Response response;
    private RequestPayload requestPayload;
    private ResponsePayload responsePayload;
    private String endpoint;

    @Given("^I have a valid endpoint$")
    public void i_have_a_valid_endpoint() {
        endpoint = Endpoints.BASE_URL + Endpoints.MY_ENDPOINT;
    }

    @Given("^I have a valid request payload$")
    public void i_have_a_valid_request_payload() {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("param1", TestDataGenerator.generateRandomString(10));
        requestData.put("param2", TestDataGenerator.generateRandomNumber(3));
        requestPayload = new RequestPayload(requestData);
    }

    @When("^I send a POST request to the endpoint$")
    public void i_send_a_post_request_to_the_endpoint() {
        response = APIClient.executeRequest(RequestBuilder.buildPOSTRequest(endpoint, requestPayload));
    }

    @Then("^the response code should be (\\d+)$")
    public void the_response_code_should_be(int expectedStatusCode) {
        ResponseValidator.validateResponseStatusCode(response, expectedStatusCode);
    }

    @Then("^the response payload should have a key \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void the_response_payload_should_have_a_key_with_value(String key, String expectedValue) {
        responsePayload = response.as(ResponsePayload.class);
        Assert.assertEquals(responsePayload.get(key), expectedValue);
    }
}
