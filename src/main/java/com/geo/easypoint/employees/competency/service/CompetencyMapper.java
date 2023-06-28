package com.geo.easypoint.employees.competency.service;

import com.geo.easypoint.employees.competency.domain.Competency;
import com.geo.easypoint.employees.competency.web.CompetencyCreateDto;
import com.geo.easypoint.employees.competency.web.CompetencyDto;
import com.geo.easypoint.common.dictionary.service.DictionaryMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetencyMapper extends DictionaryMapper<Competency, CompetencyDto, CompetencyCreateDto> {
}
