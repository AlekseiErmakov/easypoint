package com.geo.easypoint.pointstate.domain;

import jakarta.persistence.QueryHint;
import java.util.List;
import org.hibernate.jpa.AvailableHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

public interface PointTypeRepository extends JpaRepository<PointType, Long> {

    @QueryHints(@QueryHint(name = AvailableHints.HINT_CACHEABLE, value = "true"))
    List<PointType> findAll();
}
