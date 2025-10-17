package com.spring.docker1.exception;

public class TareaNotFoundException extends RuntimeException {
    public TareaNotFoundException(String message) {
        super(message);
    }
}
