package com.geo.easypoint.iml.utill;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CollectionUtils {

    public static<T,V> List<V> mapToList(Collection<T> collection, Function<T,V> mapper){
        return collection.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
