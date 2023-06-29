package com.geo.easypoint.common.dictionary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DictionaryRepository<T extends Dictionary> extends JpaRepository<T, Long> {
    boolean existsByNameAndIdNot(String name, Long id);
    boolean existsByName(String name);
}
