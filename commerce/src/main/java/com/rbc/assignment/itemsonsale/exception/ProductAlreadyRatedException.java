package com.rbc.assignment.itemsonsale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductAlreadyRatedException extends RuntimeException{
    private static final long serialVersionUID = -3108425848866753947L;
    public ProductAlreadyRatedException(String message) {
        super(message);
    }
}