package com.geo.easypoint.employees.competency.web;

import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;


public class CompetencyCreateDto extends DictionaryCreateDto {
    public CompetencyCreateDto(String name, String description) {
        super(name, description);
    }
}
