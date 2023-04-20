package utils;

import io.restassured.response.Response;

public class ResponseInterceptor {

    public static Response intercept(Response response) {
        // Your logic to intercept the response and modify it goes here
        return response;
    }

}
