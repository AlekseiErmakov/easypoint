package com.geo.easypoint.justification.pointstate.domain;

import com.geo.easypoint.justification.pointstate.web.PointStates;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Getter
@Entity
@Builder
@Cacheable
@NoArgsConstructor
@AllArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "point_states")
public class PointState {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_state_generator")
    @SequenceGenerator(name = "point_state_generator", sequenceName = "point_state_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PointStates code;
    private String name;
    private String description;
}
