package com.ab.helmesassignment.exception;

public class ValidationFailException extends RuntimeException {
    public ValidationFailException(String msg) {
        super(msg);
    }
}
