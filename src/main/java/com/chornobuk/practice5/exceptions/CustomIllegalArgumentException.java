package com.chornobuk.practice5.exceptions;

public class CustomIllegalArgumentException extends RuntimeException {
    public CustomIllegalArgumentException(String message) {
        super(message);
    }
}
