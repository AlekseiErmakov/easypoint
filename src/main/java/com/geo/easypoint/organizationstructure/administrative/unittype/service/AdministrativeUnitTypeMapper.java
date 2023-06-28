package com.geo.easypoint.organizationstructure.administrative.unittype.service;

import com.geo.easypoint.organizationstructure.administrative.unittype.domain.AdministrativeUnitType;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeCreateDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeDto;
import com.geo.easypoint.common.dictionary.service.DictionaryMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdministrativeUnitTypeMapper extends DictionaryMapper<AdministrativeUnitType, AdministrativeUnitTypeDto, AdministrativeUnitTypeCreateDto> {
}
