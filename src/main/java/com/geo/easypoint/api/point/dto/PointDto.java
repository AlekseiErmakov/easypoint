package com.geo.easypoint.api.point.dto;

import com.geo.easypoint.api.employee.dto.response.EmployeeDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PointDto(Long id, String name, BigDecimal x, BigDecimal y, BigDecimal h, LocalDate created,
                       LocalDate updated, EmployeeDto creator, PointTypeDto pointType) {
}
