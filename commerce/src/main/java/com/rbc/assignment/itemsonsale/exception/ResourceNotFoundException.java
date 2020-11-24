package com.rbc.assignment.itemsonsale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = -4234405445380062866L;
    public ResourceNotFoundException(String message) {
        super(message);
    }
}