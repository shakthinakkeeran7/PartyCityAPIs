package exception;

public class InvalidResponseCodeException extends RuntimeException {
    private int statusCode;

    public InvalidResponseCodeException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
