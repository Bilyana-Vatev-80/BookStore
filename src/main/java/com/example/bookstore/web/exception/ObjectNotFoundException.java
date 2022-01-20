package com.example.bookstore.web.exception;

public class ObjectNotFoundException extends RuntimeException{

    private final String objectName;

    public ObjectNotFoundException(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName(){
        return objectName;
    }
}
