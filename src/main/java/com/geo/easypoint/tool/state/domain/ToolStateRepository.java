package com.geo.easypoint.tool.state.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolStateRepository extends JpaRepository<ToolState, Long> {
    Optional<ToolState> findByName(String name);
    boolean existsByName(String name);

}
