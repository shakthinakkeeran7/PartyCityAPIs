package exception;

public class InvalidResponseCodeException extends RuntimeException {
    private int statusCode;

    public InvalidResponseCodeException(int statusCode) {
        super(String.format("Invalid response code: %d", statusCode));
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
