package com.geo.easypoint.iml.users.repository;

import com.geo.easypoint.iml.users.entity.EasyPointUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EasyPointUserRepository extends JpaRepository<EasyPointUser, Long> {

    @EntityGraph("user-entity-graph")
    Optional<EasyPointUser> findByUsername(String userName);
}
