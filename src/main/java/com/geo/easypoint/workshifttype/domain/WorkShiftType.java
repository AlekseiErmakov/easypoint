package com.geo.easypoint.workshifttype.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_shift_types")
public class WorkShiftType {
    @CreationTimestamp
    public LocalDateTime created;
    @UpdateTimestamp
    public LocalDateTime updated;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_shift_type_sequence_generator")
    @SequenceGenerator(name = "work_shift_type_sequence_generator", sequenceName = "work_shift_type_sequence")
    private Long id;
    private String name;
    private String shortname;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;
}
