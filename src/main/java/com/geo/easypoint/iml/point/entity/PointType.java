package com.geo.easypoint.iml.point.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "point_types")
public class PointType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_type_generator")
    @SequenceGenerator(name = "point_type_generator", sequenceName = "point_type_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PointTypes code;
    private String name;
    private String description;

}
