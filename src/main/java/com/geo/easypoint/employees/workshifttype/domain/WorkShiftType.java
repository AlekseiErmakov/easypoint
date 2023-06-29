package com.geo.easypoint.employees.workshifttype.domain;

import com.geo.easypoint.common.dictionary.domain.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_shift_types")
public class WorkShiftType extends Dictionary {
    private String shortname;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;
}
