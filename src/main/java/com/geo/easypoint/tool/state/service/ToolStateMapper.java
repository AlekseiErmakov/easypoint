package com.geo.easypoint.tool.state.service;

import com.geo.easypoint.common.dictionary.service.DictionaryMapper;
import com.geo.easypoint.tool.state.domain.ToolState;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToolStateMapper extends DictionaryMapper<ToolState, ToolStateDto, ToolStateCreateDto> {
}
