package com.geo.easypoint.iml.point.repository;

import com.geo.easypoint.iml.point.entity.Point;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PointRepository extends JpaRepository<Point, Long> {

    @EntityGraph("point-entity-graph")
    List<Point> findAll();

    @EntityGraph("point-entity-graph")
    Optional<Point> findById(Long id);
}
