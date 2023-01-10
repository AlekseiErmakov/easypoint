package com.geo.easypoint.iml.employee.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "work_shift_types")
public class WorkShiftType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_shift_type_sequence_generator")
    @SequenceGenerator(name = "work_shift_type_sequence_generator", sequenceName = "work_shift_type_sequence")
    private Long id;
    private String name;
    private String shortName;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;

    @CreationTimestamp
    public LocalDateTime created;
    @UpdateTimestamp
    public LocalDateTime updated;
}
