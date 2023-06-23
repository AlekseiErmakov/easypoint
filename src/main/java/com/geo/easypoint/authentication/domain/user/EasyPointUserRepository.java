package com.geo.easypoint.authentication.domain.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EasyPointUserRepository extends JpaRepository<EasyPointUser, Long> {

    @EntityGraph("user-entity-graph")
    Optional<EasyPointUser> findByUsername(String userName);
}
