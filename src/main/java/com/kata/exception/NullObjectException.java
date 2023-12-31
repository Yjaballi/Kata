package com.kata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NullObjectException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NullObjectException() {
        super("Null Object");
    }
    
    public NullObjectException(String message) {
        super(message);
    }
}
