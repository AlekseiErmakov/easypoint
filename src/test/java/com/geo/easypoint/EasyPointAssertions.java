package com.geo.easypoint;

import org.springframework.data.jpa.repository.JpaRepository;


public final class EasyPointAssertions {

    public static <E extends JpaRepository<T, I>, T, I> JpaRepositoryAssertions<E, T, I> assertThat(E repository) {
        return new JpaRepositoryAssertions<>(repository);
    }
}
