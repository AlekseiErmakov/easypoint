package com.geo.easypoint.point.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {

    @EntityGraph(value = "point-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    List<Point> findAll();

    @EntityGraph("point-entity-graph")
    Optional<Point> findById(Long id);
}
