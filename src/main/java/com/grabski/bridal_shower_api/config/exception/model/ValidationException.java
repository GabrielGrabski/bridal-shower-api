package com.grabski.bridal_shower_api.config.exception.model;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
