package com.geo.easypoint.organizationstructure.area.structuretype.web;

import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;


public class AreaStructureTypeCreateDto extends DictionaryCreateDto {
    public AreaStructureTypeCreateDto(String name, String description) {
        super(name, description);
    }
}
