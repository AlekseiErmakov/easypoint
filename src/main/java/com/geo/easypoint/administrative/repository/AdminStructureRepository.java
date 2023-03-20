package com.geo.easypoint.administrative.repository;

import com.geo.easypoint.administrative.entity.AdminStructure;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminStructureRepository extends JpaRepository<AdminStructure, Long> {
    @EntityGraph("admin-structure-graph")
    List<AdminStructure> findAllByParentIsNull();
}
