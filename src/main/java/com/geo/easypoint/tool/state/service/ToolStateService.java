package com.geo.easypoint.tool.state.service;

import com.geo.easypoint.common.dictionary.service.BaseDictionaryService;
import com.geo.easypoint.tool.state.domain.ToolState;
import com.geo.easypoint.tool.state.domain.ToolStateRepository;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateDto;
import com.geo.easypoint.tool.state.web.ToolStateUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class ToolStateService extends BaseDictionaryService<ToolState, ToolStateDto, ToolStateCreateDto, ToolStateUpdateDto> {

    public ToolStateService(ToolStateRepository toolStateRepository, ToolStateMapper toolStateMapper) {
        super(toolStateRepository, toolStateMapper);
    }

}
