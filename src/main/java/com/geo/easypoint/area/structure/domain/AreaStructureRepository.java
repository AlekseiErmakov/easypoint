package com.geo.easypoint.area.structure.domain;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaStructureRepository extends JpaRepository<AreaStructure, Long> {

    @EntityGraph("area-structure-graph")
    List<AreaStructure> findAllByParentIsNull();
}
