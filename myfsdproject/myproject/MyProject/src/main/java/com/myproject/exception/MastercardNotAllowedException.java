package com.myproject.exception;

public class MastercardNotAllowedException extends RuntimeException {
    public MastercardNotAllowedException(String message) {
        super(message);
    }
}
