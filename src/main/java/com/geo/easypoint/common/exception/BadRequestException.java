package com.geo.easypoint.common.exception;

public class BadRequestException extends EasyPointException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable e) {
        super(message, e);
    }
}
