package com.geo.easypoint.common.dictionary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDictionaryRepository<T extends BaseDictionary> extends JpaRepository<T, Long> {
    boolean existsByName(String name);
}
