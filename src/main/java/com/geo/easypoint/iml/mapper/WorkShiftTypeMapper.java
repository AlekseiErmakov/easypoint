package com.geo.easypoint.iml.mapper;

import com.geo.easypoint.api.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.api.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.iml.employee.entity.WorkShiftType;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface WorkShiftTypeMapper {
    WorkShiftTypeDto toWorkShiftTypeDto(WorkShiftType workShiftType);
    List<WorkShiftTypeDto> toWorkShiftTypeDto(Collection<WorkShiftType> workShiftTypes);
    WorkShiftType toWorkShiftType(WorkShiftTypeCreateRequest workShiftTypeCreateRequest);
}
