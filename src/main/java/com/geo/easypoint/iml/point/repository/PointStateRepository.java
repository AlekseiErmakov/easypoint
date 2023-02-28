package com.geo.easypoint.iml.point.repository;

import com.geo.easypoint.iml.point.entity.PointState;
import com.geo.easypoint.iml.point.entity.PointStates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PointStateRepository extends JpaRepository<PointState, Long> {
    PointState findByCode(PointStates code);
}
