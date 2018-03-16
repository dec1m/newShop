package ru.trach.exceptions;

public class NoValidDataException extends  Exception {
    private String message;
    @Override
    public String getMessage() {
        return message;
    }

    public NoValidDataException(String message) {
        this.message = message;
    }
}
