package com.geo.easypoint.employees.competency.domain;

import com.geo.easypoint.common.dictionary.domain.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@Table(name = "competencies")
public class Competency extends Dictionary {
}
