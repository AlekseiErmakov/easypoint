package com.geo.easypoint.api.employee.dto.response;

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
