package com.geo.easypoint.api.employee.dto.request;

public record WorkShiftTypeCreateRequest(
        String name,
        String shortName,
        Integer startHour,
        Integer startMinute,
        Integer endHour,
        Integer endMinute
) {
}
