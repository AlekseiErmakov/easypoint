package com.geo.easypoint.organizationstructure.administrative.unit.domain;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrativeUnitRepository extends JpaRepository<AdministrativeUnit, Long> {
    @EntityGraph("admin-structure-graph")
    List<AdministrativeUnit> findAllByParentIsNull();
}
