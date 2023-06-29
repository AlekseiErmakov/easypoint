package com.geo.easypoint.employees.workshifttype.service;

import com.geo.easypoint.common.dictionary.service.DictionaryMapper;
import com.geo.easypoint.employees.workshifttype.domain.WorkShiftType;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeCreateDto;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkShiftTypeMapper extends DictionaryMapper<WorkShiftType, WorkShiftTypeDto, WorkShiftTypeCreateDto> {
}
