package com.geo.easypoint.employee.dto.request;

public record WorkShiftTypeCreateRequest(
        String name,
        String shortname,
        Integer startHour,
        Integer startMinute,
        Integer endHour,
        Integer endMinute
) {
}
