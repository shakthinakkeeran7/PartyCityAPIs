package utils;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class RequestInterceptor implements io.restassured.filter.Filter {

    private static RequestSpecification requestSpec;

    static {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("username");
        authScheme.setPassword("password");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.example.com")
                .setAuth(authScheme)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Override
    public io.restassured.response.Response filter(io.restassured.filter.FilterableRequestSpecification requestSpec,
                                                    io.restassured.filter.FilterableResponseSpecification responseSpec,
                                                    io.restassured.filter.FilterContext ctx) {

        // Modify request here
        requestSpec.header("Authorization", "Bearer token");

        // Log request details
        RestAssured.logSpecification(requestSpec);
        return ctx.next(requestSpec, responseSpec);
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }
}
