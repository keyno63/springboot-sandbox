package jp.co.who.spring_tutorial.exception;

public class SomethingException extends Exception {
    private String message;
    SomethingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
