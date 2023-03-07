package com.geo.easypoint.common.exception;

public abstract class EasyPointException extends RuntimeException {
    public EasyPointException(String message) {
        super(message);
    }

    public EasyPointException(String message, Throwable e) {
        super(message, e);
    }
}
