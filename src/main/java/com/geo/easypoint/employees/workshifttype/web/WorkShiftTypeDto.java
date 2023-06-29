package com.geo.easypoint.employees.workshifttype.web;

import com.geo.easypoint.common.dictionary.web.DictionaryDto;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@SuperBuilder
public class WorkShiftTypeDto extends DictionaryDto {
    private final String shortname;
    private final Integer startHour;
    private final Integer startMinute;
    private final Integer endHour;
    private final Integer endMinute;
}
