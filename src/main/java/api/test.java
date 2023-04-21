package api;

import static io.restassured.RestAssured.given;

import java.net.URI;
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

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class test {

	private static HH hh = new HH(null);
	private static RequestBuilder requestBuilder = new RequestBuilder(null); ;
	public test() {
		
	}

	private static final String BASE_URI = "http://localhost:8081";

	private static final RestAssuredConfig CONFIG = RestAssured.config()
			.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

	public static Response sendGetRequest(String endpoint, Map<String, String> headers) {
		return RestAssured.given().config(CONFIG).headers(headers).get(endpoint).andReturn();
	}

	public static void main(String[] args) {
		requestBuilder.withHeader("dd", "ff");

		System.out.println(requestBuilder.getHeaders());
		// String a = BASE_URI + "/posts/1";
		// Response sendGetRequest = sendGetRequest(a, withHeader);
		// Response response = given().when().get(BASE_URI + "/posts/1");

		// System.out.println(sendGetRequest.getBody().asPrettyString());

	}
}
