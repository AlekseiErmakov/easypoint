package com.geo.easypoint.iml.exception;

public class NotFoundException extends EasyPointException {
    public NotFoundException(Object id, Class<?> entity) {
        super(String.format("Entity %s with %s not found!", entity, id));
    }
}
