package api;

import io.restassured.response.Response;

public class ResponseValidator {
    
    public static void validateResponse(Response response) {
        int statusCode = response.getStatusCode();
        switch (statusCode) {
            case 200:
                // Handle response for successful request (200 OK)
                break;
            case 201:
                // Handle response for successful creation (201 Created)
                break;
            case 204:
                // Handle response for successful deletion (204 No Content)
                break;
            case 400:
                // Handle response for bad request (400 Bad Request)
                throw new InvalidResponseCodeException("Invalid response code: " + statusCode);
            case 401:
                // Handle response for unauthorized access (401 Unauthorized)
                throw new ApiException("Unauthorized access");
            case 403:
                // Handle response for forbidden access (403 Forbidden)
                throw new ApiException("Forbidden access");
            case 404:
                // Handle response for resource not found (404 Not Found)
                throw new ApiException("Resource not found");
            case 500:
                // Handle response for internal server error (500 Internal Server Error)
                throw new ApiException("Internal server error");
            default:
                // Handle response for any other status code not covered above
                throw new InvalidResponseCodeException("Invalid response code: " + statusCode);
        }
    }
}
