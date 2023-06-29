package com.geo.easypoint.employees.workshifttype.web;

import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import lombok.Getter;

@Getter
public class WorkShiftTypeCreateDto extends DictionaryCreateDto {
    private final String shortname;
    private final Integer startHour;
    private final Integer startMinute;
    private final Integer endHour;
    private final Integer endMinute;

    public WorkShiftTypeCreateDto(String name, String description, String shortname, Integer startHour, Integer startMinute, Integer endHour, Integer endMinute) {
        super(name, description);
        this.shortname = shortname;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }
}
