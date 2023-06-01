package com.geo.easypoint.employee.dto.response;

import com.geo.easypoint.employee.entity.Sex;

import java.time.LocalDate;

public record PassportInfoDto(String number,
                              LocalDate birthDate,
                              Sex sex,
                              LocalDate issueDate,
                              LocalDate expiredDate,
                              String authority
) {
}
