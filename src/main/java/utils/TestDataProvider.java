package utils;

import java.util.HashMap;
import java.util.Map;

public class TestDataProvider {
    
    public static Map<String, Object> getTestData() {
        Map<String, Object> testData = new HashMap<>();
        
        // Generate test data for a POST request
        testData.put("endpoint", "/api/users");
        testData.put("requestMethod", "POST");
        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("name", "John Doe");
        requestPayload.put("email", "johndoe@example.com");
        testData.put("requestPayload", requestPayload);
        
        // Generate test data for a GET request
        testData.put("endpoint", "/api/users/1");
        testData.put("requestMethod", "GET");
        
        // Generate test data for a PUT request
        testData.put("endpoint", "/api/users/1");
        testData.put("requestMethod", "PUT");
        Map<String, Object> updatedPayload = new HashMap<>();
        updatedPayload.put("name", "Jane Doe");
        updatedPayload.put("email", "janedoe@example.com");
        testData.put("requestPayload", updatedPayload);
        
        // Generate test data for a DELETE request
        testData.put("endpoint", "/api/users/1");
        testData.put("requestMethod", "DELETE");
        
        return testData;
    }
}
