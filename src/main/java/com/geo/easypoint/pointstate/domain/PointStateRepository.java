package com.geo.easypoint.pointstate.domain;

import com.geo.easypoint.pointstate.web.PointStates;
import com.geo.easypoint.pointstate.domain.PointState;
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
