package com.geo.easypoint.justification.point.web;

import com.geo.easypoint.justification.pointstate.web.PointStateDto;
import com.geo.easypoint.justification.pointtype.web.PointTypeDto;
import com.geo.easypoint.organizationstructure.area.structure.web.AreaDto;
import com.geo.easypoint.employees.employee.dto.response.EmployeeTableDto;
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
                       EmployeeTableDto creator,
                       PointTypeDto pointType,
                       PointStateDto pointState,
                       List<AreaDto> areas) {
}
