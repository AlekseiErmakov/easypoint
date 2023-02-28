package com.geo.easypoint.iml.point.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
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
