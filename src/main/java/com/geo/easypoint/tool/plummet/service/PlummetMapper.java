package com.geo.easypoint.tool.plummet.service;

import com.geo.easypoint.common.dictionary.service.DictionaryMapper;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import com.geo.easypoint.tool.plummet.web.PlummetCreateDto;
import com.geo.easypoint.tool.plummet.web.PlummetDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlummetMapper extends DictionaryMapper<Plummet, PlummetDto, PlummetCreateDto> {
}
