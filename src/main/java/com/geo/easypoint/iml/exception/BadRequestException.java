package com.geo.easypoint.iml.exception;

public class BadRequestException extends EasyPointException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable e) {
        super(message, e);
    }
}
