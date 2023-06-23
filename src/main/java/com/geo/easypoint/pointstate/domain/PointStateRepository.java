package com.geo.easypoint.pointstate.domain;

import com.geo.easypoint.pointstate.web.PointStates;
import jakarta.persistence.QueryHint;
import java.util.List;
import org.hibernate.jpa.AvailableHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

public interface PointStateRepository extends JpaRepository<PointState, Long> {

    @QueryHints(@QueryHint(name = AvailableHints.HINT_CACHEABLE, value = "true"))
    PointState findByCode(PointStates code);

    @QueryHints(@QueryHint(name = AvailableHints.HINT_CACHEABLE, value = "true"))
    List<PointState> findAll();
}
