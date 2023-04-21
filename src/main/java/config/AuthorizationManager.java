package config;

import java.util.Map;

public class AuthorizationManager {
	private final TestEnvironment testEnvironment;
    private static String authToken;
    private Map<String, String> headers;

    public AuthorizationManager(TestEnvironment testEnvironment) {
    	 this.testEnvironment = testEnvironment;
	}

	public static String getAuthToken() {
        if(authToken == null) {
            // Authenticate and retrieve auth token
            authToken = authenticateAndGetToken();
        }
        return authToken;
    }
    
    public String getAuthorizationHeader() {
        String token = AuthorizationManager.getAuthToken();
        if (token != null) {
            headers.put("Authorization", "Bearer " + token);
        }
		return token;
    }

    private static String authenticateAndGetToken() {
        // Authenticate with username and password and retrieve token
        // This can be implemented using REST API calls to the authentication server
        return "SAMPLE_AUTH_TOKEN";
    }
}
