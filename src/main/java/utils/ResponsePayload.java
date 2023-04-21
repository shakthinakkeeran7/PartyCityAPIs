package utils;

public class ResponsePayload {
    private String message;
    private int status;
    private Object data;

    public ResponsePayload(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    // Getters and setters for message, status, and data

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
