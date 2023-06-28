package com.geo.easypoint.organizationstructure.area.structuretype.service;

import com.geo.easypoint.organizationstructure.area.structuretype.domain.AreaStructureType;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeCreateDto;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeDto;
import com.geo.easypoint.common.dictionary.service.DictionaryMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaStructureTypeMapper extends DictionaryMapper<AreaStructureType, AreaStructureTypeDto, AreaStructureTypeCreateDto> {
}
