package com.geo.easypoint.tool.state.web;

import com.geo.easypoint.common.dictionary.web.BaseDictionaryController;
import com.geo.easypoint.tool.state.domain.ToolState;
import com.geo.easypoint.tool.state.service.ToolStateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool-states")
public class ToolStateController extends BaseDictionaryController<ToolState, ToolStateDto, ToolStateCreateDto, ToolStateUpdateDto> {

    public ToolStateController(ToolStateService service) {
        super(service);
    }
}
