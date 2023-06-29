package com.geo.easypoint.employees.workshifttype.web;

import com.geo.easypoint.common.dictionary.web.DictionaryUpdateDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Jacksonized
@SuperBuilder
public class WorkShiftTypeUpdateDto extends DictionaryUpdateDto {
    private final JsonNullable<String> shortname;
    private final JsonNullable<Integer> startHour;
    private final JsonNullable<Integer> startMinute;
    private final JsonNullable<Integer> endHour;
    private final JsonNullable<Integer> endMinute;
}
