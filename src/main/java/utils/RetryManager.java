package utils;

import io.restassured.response.Response;
import org.awaitility.Awaitility;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class RetryManager {

    private static final int DEFAULT_MAX_RETRIES = 3;
    private static final Duration DEFAULT_WAIT_DURATION = Duration.ofSeconds(5);

    public static Response executeWithRetry(Supplier<Response> requestFunction) {
        return executeWithRetry(requestFunction, DEFAULT_MAX_RETRIES, DEFAULT_WAIT_DURATION);
    }

    public static Response executeWithRetry(Supplier<Response> requestFunction, int maxRetries, Duration waitDuration) {
        return Awaitility.await()
                .pollInterval(waitDuration)
                .atMost(waitDuration.multipliedBy(maxRetries))
                .until(getResponse(requestFunction))
                .getResponse();
    }

    private static Callable<ResponseWrapper> getResponse(Supplier<Response> requestFunction) {
        return () -> new ResponseWrapper(requestFunction.get());
    }

    private static class ResponseWrapper {
        private Response response;

        public ResponseWrapper(Response response) {
            this.response = response;
        }

        public Response getResponse() {
            return response;
        }

        public boolean isSuccessful() {
            return response.getStatusCode() >= 200 && response.getStatusCode() < 300;
        }
    }
}
