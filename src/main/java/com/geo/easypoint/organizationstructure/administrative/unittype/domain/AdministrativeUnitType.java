package com.geo.easypoint.organizationstructure.administrative.unittype.domain;

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
@Table(name = "administrative_unit_types")
public class AdministrativeUnitType extends BaseDictionary {
}
