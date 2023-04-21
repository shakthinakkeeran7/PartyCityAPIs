package api;

import config.AuthorizationManager;
import config.TestEnvironment;
import io.restassured.response.Response;

public class APItest2 {
	public final TestEnvironment testEnvironment;
	public final api.RequestBuilder requestBuilder;
	private AuthorizationManager authManager;
	public final APIClient apiClient;
	
	public APItest2(TestEnvironment testEnvironment) {
		this.apiClient = new APIClient(testEnvironment);
		this.testEnvironment = testEnvironment;
		this.requestBuilder = new RequestBuilder(authManager);
		this.authManager = new AuthorizationManager(testEnvironment);
		
		
	}
	@org.testng.annotations.Test(priority = 1)
	public void a_request_header_of(String string) {
	System.out.println("z");
	
	}

}
