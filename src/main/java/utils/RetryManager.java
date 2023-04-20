package utils;

import io.restassured.response.Response;

public class RetryManager {
    
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_INTERVAL = 5000; // 5 seconds
    
    public static Response retryRequest(APIClient client, RequestBuilder request) {
        int retryCount = 0;
        Response response = null;
        while (retryCount < MAX_RETRIES) {
            response = client.sendRequest(request);
            if (response.getStatusCode() < 400) {
                break;
            }
            retryCount++;
            try {
                Thread.sleep(RETRY_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}
