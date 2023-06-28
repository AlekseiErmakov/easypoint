package com.geo.easypoint.employees.employee.dto.response;

import com.geo.easypoint.employees.employee.entity.Sex;
import java.time.LocalDate;

public record PassportInfoDto(String number,
                              LocalDate birthDate,
                              Sex sex,
                              LocalDate issueDate,
                              LocalDate expiredDate,
                              String authority
) {
}
