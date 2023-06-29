package com.geo.easypoint.tool.plummet.web;

import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;


public class PlummetCreateDto extends DictionaryCreateDto {
    public PlummetCreateDto(String name, String description) {
        super(name, description);
    }
}
