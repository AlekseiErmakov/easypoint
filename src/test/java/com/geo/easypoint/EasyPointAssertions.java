package com.geo.easypoint;

import org.springframework.data.jpa.repository.JpaRepository;


public final class EasyPointAssertions {

    public static <E extends JpaRepository<T, ID>, T, ID> JpaRepositoryAssertions<E, T, ID> assertThat(E repository) {
        return new JpaRepositoryAssertions<>(repository);
    }
}
