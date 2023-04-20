package config;

public class AppConfig {
    private String baseUrl;
    private String apiKey;
    private String secretKey;
    private int connectionTimeout;
    private int socketTimeout;

    public AppConfig(String baseUrl, String apiKey, String secretKey, int connectionTimeout, int socketTimeout) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.connectionTimeout = connectionTimeout;
        this.socketTimeout = socketTimeout;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }
}
