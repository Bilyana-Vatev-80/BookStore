package com.example.bookstore.web.exception;

public class InvalidOrderException extends RuntimeException{

    private final String message;

    public InvalidOrderException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
