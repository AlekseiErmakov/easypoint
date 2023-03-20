package com.geo.easypoint.point.dto;

import com.geo.easypoint.area.dto.AreaDto;
import com.geo.easypoint.employee.dto.response.EmployeeDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PointDto(Long id,
                       String name,
                       BigDecimal x,
                       BigDecimal y,
                       BigDecimal h,
                       LocalDate created,
                       Long rootAreaId,
                       LocalDate updated,
                       EmployeeDto creator,
                       PointTypeDto pointType,
                       PointStateDto pointState,
                       List<AreaDto> areas) {
}
