package com.geo.easypoint.impl.exception;

import java.util.Optional;
import java.util.function.Function;

public class NotFoundException extends EasyPointException {
    public NotFoundException(Object id, Class<?> entity) {
        super(String.format("Entity %s with %s not found!", entity, id));
    }

    public static <V, T> T orElseThrow(V id, Class<?> entityClass, Function<V, Optional<T>> function) {
        return function.apply(id)
                .orElseThrow(() -> new NotFoundException(id, entityClass));
    }
}
