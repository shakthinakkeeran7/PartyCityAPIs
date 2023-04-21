package config;

public class TestEnvironment {
    private String baseUrl;
    private String apiEndpoint;

    public TestEnvironment(String baseUrl, String apiEndpoint) {
        this.baseUrl = baseUrl;
        this.apiEndpoint = apiEndpoint;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApiEndpoint() {
        return this.apiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }
    
    public String getFullUrl() {
        return this.baseUrl + this.apiEndpoint;
    }
}
