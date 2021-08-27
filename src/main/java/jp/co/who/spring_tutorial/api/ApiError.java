package jp.co.who.spring_tutorial.api;

public class ApiError {
    private static final int id = 100;
    private String message;
    private String exception;

    public ApiError(String message, String exception) {
        this.message = message;
        this.exception = exception;
    }

    public int getId() {
        return this.id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
    public void setException(String exception) { this.exception = exception; }
    public String getException() { return this.exception; };
}
