package com.geo.easypoint.common.mapper;

import org.openapitools.jackson.nullable.JsonNullable;

import java.util.function.Consumer;

public class PartialUpdater {

    public static PartialUpdater updater() {
        return new PartialUpdater();
    }

    public <T> PartialUpdater update(JsonNullable<T> value, Consumer<T> consumer) {
        if (value.isPresent()) {
            consumer.accept(value.get());
        }
        return this;
    }
}
