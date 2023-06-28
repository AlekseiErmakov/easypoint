package com.geo.easypoint.employees.employee.dto.response;

import com.geo.easypoint.organizationstructure.administrative.unit.web.AdministrativeUnitDto;
import com.geo.easypoint.employees.competency.web.CompetencyDto;
import com.geo.easypoint.employees.jobtitle.web.JobTitleDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EmployeeDto(
        Long id,
        String firstname,
        String surname,
        String lastname,
        LocalDateTime created,
        LocalDateTime updated,
        LocalDate hiredDate,
        LocalDate firedDate,
        List<AdministrativeUnitDto> administrativeUnits,
        AddressDto address,
        PassportInfoDto passportInfo,
        JobTitleDto jobTitle,
        CompetencyDto competency
) {


}
