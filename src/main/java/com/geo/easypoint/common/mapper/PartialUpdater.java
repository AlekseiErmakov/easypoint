package com.geo.easypoint.common.mapper;

import java.util.function.Consumer;
import org.openapitools.jackson.nullable.JsonNullable;

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
