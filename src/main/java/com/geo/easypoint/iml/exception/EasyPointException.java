package com.geo.easypoint.iml.exception;

public abstract class EasyPointException extends RuntimeException {
    public EasyPointException(String message) {
        super(message);
    }

    public EasyPointException(String message, Throwable e) {
        super(message, e);
    }
}
