package jp.co.who.spring_tutorial.api;

import java.io.Serializable;

public class ApiError implements Serializable {
    private static final int id = 1;
    private String message;

    public int getId() {
        return this.id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
