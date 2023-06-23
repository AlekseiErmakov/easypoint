package com.geo.easypoint.tool.plummet.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlummetRepository extends JpaRepository<Plummet, Long> {

    boolean existsByName(String name);
}
