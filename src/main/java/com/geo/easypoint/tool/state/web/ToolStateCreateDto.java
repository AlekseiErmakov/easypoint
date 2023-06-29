package com.geo.easypoint.tool.state.web;

import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;


public class ToolStateCreateDto extends DictionaryCreateDto {
    public ToolStateCreateDto(String name, String description) {
        super(name, description);
    }
}
