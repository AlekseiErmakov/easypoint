package com.geo.easypoint.point.repository;

import com.geo.easypoint.point.entity.PointState;
import com.geo.easypoint.point.dto.PointStates;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.AvailableHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface PointStateRepository extends JpaRepository<PointState, Long> {

    @QueryHints(@QueryHint(name = AvailableHints.HINT_CACHEABLE, value = "true"))
    PointState findByCode(PointStates code);

    @QueryHints(@QueryHint(name = AvailableHints.HINT_CACHEABLE, value = "true"))
    List<PointState> findAll();
}
