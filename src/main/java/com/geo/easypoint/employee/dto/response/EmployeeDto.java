package com.geo.easypoint.employee.dto.response;

import java.time.LocalDateTime;

public record EmployeeDto(
        Long id,
        String firstname,
        String surname,
        String lastname,
        LocalDateTime created,
        LocalDateTime updated) {
}
