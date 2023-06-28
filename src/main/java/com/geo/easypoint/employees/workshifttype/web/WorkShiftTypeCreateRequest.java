package com.geo.easypoint.employees.workshifttype.web;

public record WorkShiftTypeCreateRequest(
        String name,
        String shortname,
        Integer startHour,
        Integer startMinute,
        Integer endHour,
        Integer endMinute
) {
}
