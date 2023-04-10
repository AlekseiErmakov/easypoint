package com.geo.easypoint.administrative.entity;

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
@Table(name = "administrative_unit_types")
public class AdministrativeUnitType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrative_unit_types_generator")
    @SequenceGenerator(name = "administrative_unit_types_generator", sequenceName = "administrative_unit_types_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}
