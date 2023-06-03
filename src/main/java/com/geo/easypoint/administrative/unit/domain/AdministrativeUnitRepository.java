package com.geo.easypoint.administrative.unit.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministrativeUnitRepository extends JpaRepository<AdministrativeUnit, Long> {
    @EntityGraph("admin-structure-graph")
    List<AdministrativeUnit> findAllByParentIsNull();
}
