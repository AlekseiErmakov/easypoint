package com.geo.easypoint.employee.dto.response;

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
