package com.geo.easypoint.iml.point.entity;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Getter
@Entity
@Cacheable
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
