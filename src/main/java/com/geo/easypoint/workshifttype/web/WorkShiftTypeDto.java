package com.geo.easypoint.workshifttype.web;

public record WorkShiftTypeDto(
        Long id,
        String name,
        String shortname,
        Integer startHour,
        Integer startMinute,
        Integer endHour,
        Integer endMinute
) {
}
