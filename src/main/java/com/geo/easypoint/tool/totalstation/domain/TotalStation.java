package com.geo.easypoint.tool.totalstation.domain;

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

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "total_stations")
public class TotalStation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "total_stations_seq_generator")
    @SequenceGenerator(name = "total_stations_seq_generator", sequenceName = "total_stations_seq")
    private Long id;
    private String firm;
    private String model;
    private String serialNumber;
    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}
