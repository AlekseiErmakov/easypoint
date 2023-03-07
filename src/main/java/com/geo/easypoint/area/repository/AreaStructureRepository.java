package com.geo.easypoint.area.repository;

import com.geo.easypoint.area.entity.AreaStructure;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaStructureRepository extends JpaRepository<AreaStructure, Long> {

    @EntityGraph("area-structure-graph")
    List<AreaStructure> findAllByParentIsNull();
}
