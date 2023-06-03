package com.geo.easypoint.pointstate.domain;

import com.geo.easypoint.pointstate.domain.PointType;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.AvailableHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface PointTypeRepository extends JpaRepository<PointType, Long> {

    @QueryHints(@QueryHint(name = AvailableHints.HINT_CACHEABLE, value = "true"))
    List<PointType> findAll();
}
