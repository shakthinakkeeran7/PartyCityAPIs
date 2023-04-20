package api;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIClient {

    private static final RestAssuredConfig CONFIG = RestAssured.config()
            .encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

    public static Response sendGetRequest(String endpoint, Map<String, String> headers, Map<String, ?> queryParams) {
        return RestAssured.given()
                .config(CONFIG)
                .headers(headers)
                .queryParams(queryParams)
                .get(endpoint)
                .andReturn();
    }

    public static Response sendPostRequest(String endpoint, Map<String, String> headers, Object requestBody) {
        return RestAssured.given()
                .config(CONFIG)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(endpoint)
                .andReturn();
    }

    public static Response sendPutRequest(String endpoint, Map<String, String> headers, Object requestBody) {
        return RestAssured.given()
                .config(CONFIG)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(endpoint)
                .andReturn();
    }

    public static Response sendDeleteRequest(String endpoint, Map<String, String> headers) {
        return RestAssured.given()
                .config(CONFIG)
                .headers(headers)
                .delete(endpoint)
                .andReturn();
    }
}
