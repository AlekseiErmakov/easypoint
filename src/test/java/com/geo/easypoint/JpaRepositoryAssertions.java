package com.geo.easypoint;

import org.assertj.core.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.data.jpa.repository.JpaRepository;


public class JpaRepositoryAssertions<E extends JpaRepository<T, I>, T, I> {

    private final E repository;

    public JpaRepositoryAssertions(E repository) {
        this.repository = repository;
    }

    public void save(T value) {
        ArgumentCaptor<T> argumentCaptor = ArgumentCaptor.forClass((Class<T>) value.getClass());
        Mockito.verify(repository).save(argumentCaptor.capture());

        Assertions.assertThat(argumentCaptor.getValue())
                .usingRecursiveComparison()
                .isEqualTo(value);
    }

    public void delete(T value) {
        ArgumentCaptor<T> argumentCaptor = ArgumentCaptor.forClass((Class<T>) value.getClass());
        Mockito.verify(repository).delete(argumentCaptor.capture());

        Assertions.assertThat(argumentCaptor.getValue())
                .usingRecursiveComparison()
                .isEqualTo(value);
    }

    public void neverDelete(T value) {
        ArgumentCaptor<T> argumentCaptor = ArgumentCaptor.forClass((Class<T>) value.getClass());
        Mockito.verify(repository, Mockito.never()).delete(argumentCaptor.capture());

        Assertions.assertThat(argumentCaptor.getAllValues())
                .isEmpty();
    }
}
