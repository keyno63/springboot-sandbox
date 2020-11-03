package jp.co.who.spring_tutorial.api;

import java.io.Serializable;

public class ApiError implements Serializable {
    private static final int id = 100;
    private String message;
    private String exception;

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
