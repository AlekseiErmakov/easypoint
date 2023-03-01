package com.geo.easypoint.iml.users.repository;

import com.geo.easypoint.iml.users.entity.Token;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @EntityGraph("token-graph")
    @Query(value = """
            select t from Token t inner join EasyPointUser u\s
            on t.user.id = u.id\s
            where u.id = :id and (t.expired = false or t.revoked = false)\s
            """)
    List<Token> findAllValidTokenByUser(Long id);

    @EntityGraph("token-graph")
    Optional<Token> findByToken(String token);
}
