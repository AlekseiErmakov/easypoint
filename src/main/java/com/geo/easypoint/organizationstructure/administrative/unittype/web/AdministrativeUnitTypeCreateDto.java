package com.geo.easypoint.organizationstructure.administrative.unittype.web;

import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

public class AdministrativeUnitTypeCreateDto extends DictionaryCreateDto {
    public AdministrativeUnitTypeCreateDto(String name, String description) {
        super(name, description);
    }
}