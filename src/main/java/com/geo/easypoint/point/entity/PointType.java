package com.geo.easypoint.point.entity;


import com.geo.easypoint.point.dto.PointTypes;
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

@Entity
@Getter
@Table(name = "point_types")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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
