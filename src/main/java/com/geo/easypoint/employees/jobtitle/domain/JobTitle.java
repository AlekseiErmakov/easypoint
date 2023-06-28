package com.geo.easypoint.employees.jobtitle.domain;

import com.geo.easypoint.common.dictionary.domain.BaseDictionary;
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
@Table(name = "job_titles")
public class JobTitle extends BaseDictionary {

}
