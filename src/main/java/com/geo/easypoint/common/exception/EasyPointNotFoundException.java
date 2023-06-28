package com.geo.easypoint.common.exception;

import java.util.Optional;
import java.util.function.Function;

public class EasyPointNotFoundException extends EasyPointException {
    public EasyPointNotFoundException(Object id, Class<?> entity) {
        super(String.format("Entity %s with %s not found!", entity, id));
    }

    public EasyPointNotFoundException(String message) {
        super(message);
    }

    public EasyPointNotFoundException(Long id) {
        super("Entity with id: " + id + "not found");
    }

    public static <V, T> T orElseThrow(V id, Class<?> entityClass, Function<V, Optional<T>> function) {
        return function.apply(id)
                .orElseThrow(() -> new EasyPointNotFoundException(id, entityClass));
    }
}
