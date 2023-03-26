package com.geo.easypoint.employee.dto.response;

import com.geo.easypoint.administrative.dto.AdminStructureDto;

import java.time.LocalDateTime;
import java.util.List;

public record EmployeeDto(
        Long id,
        String firstname,
        String surname,
        String lastname,
        LocalDateTime created,
        LocalDateTime updated,
        List<AdminStructureDto> adminStructures) {
}
