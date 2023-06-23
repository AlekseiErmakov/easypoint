package com.geo.easypoint.point.web;

import com.geo.easypoint.area.structure.web.AreaDto;
import com.geo.easypoint.employee.dto.response.EmployeeTableDto;
import com.geo.easypoint.pointstate.web.PointStateDto;
import com.geo.easypoint.pointtype.web.PointTypeDto;
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
