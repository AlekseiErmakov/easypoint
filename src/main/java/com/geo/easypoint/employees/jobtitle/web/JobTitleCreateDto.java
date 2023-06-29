package com.geo.easypoint.employees.jobtitle.web;

import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

public class JobTitleCreateDto extends DictionaryCreateDto {
    public JobTitleCreateDto(String name, String description) {
        super(name, description);
    }
}
