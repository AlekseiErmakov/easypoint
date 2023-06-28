package com.geo.easypoint.employees.employee.dto.response;

import com.geo.easypoint.organizationstructure.administrative.unit.web.AdministrativeUnitDto;
import java.time.LocalDateTime;
import java.util.List;

public record EmployeeTableDto(
        Long id,
        String firstname,
        String surname,
        String lastname,
        LocalDateTime created,
        LocalDateTime updated,
        List<AdministrativeUnitDto> administrativeUnits) {
}
