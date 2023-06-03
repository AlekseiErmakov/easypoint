package com.geo.easypoint.area.structuretype.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "area_structure_types")
public class AreaStructureType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_structure_types_generator")
    @SequenceGenerator(name = "area_structure_types_generator", sequenceName = "area_structure_types_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}
