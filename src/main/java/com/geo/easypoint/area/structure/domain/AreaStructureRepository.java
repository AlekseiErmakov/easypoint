package com.geo.easypoint.area.structure.domain;

import com.geo.easypoint.area.structure.domain.AreaStructure;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaStructureRepository extends JpaRepository<AreaStructure, Long> {

    @EntityGraph("area-structure-graph")
    List<AreaStructure> findAllByParentIsNull();
}
