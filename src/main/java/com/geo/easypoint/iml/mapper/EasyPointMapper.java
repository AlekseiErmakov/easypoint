package com.geo.easypoint.iml.mapper;

import com.geo.easypoint.api.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.api.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.api.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.iml.employee.entity.Employee;
import com.geo.easypoint.iml.employee.entity.WorkShiftType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EasyPointMapper {
    private static final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);
    private static final WorkShiftTypeMapper workShiftTypeMapper = Mappers.getMapper(WorkShiftTypeMapper.class);

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return employeeMapper.toEmployeeDto(employee);
    }

    public static List<EmployeeDto> toEmployeeDto(Collection<Employee> employees) {
        return employeeMapper.toEmployeeDto(employees);
    }

    public static Employee toEmployee(CreateEmployeeRequest createEmployeeRequest) {
        return employeeMapper.toEmployee(createEmployeeRequest);
    }

    public static WorkShiftTypeDto toWorkShiftTypeDto(WorkShiftType workShiftType) {
        return workShiftTypeMapper.toWorkShiftTypeDto(workShiftType);
    }

    public static List<WorkShiftTypeDto> toWorkShiftTypeDto(Collection<WorkShiftType> workShiftTypes) {
        return workShiftTypeMapper.toWorkShiftTypeDto(workShiftTypes);
    }

    public static WorkShiftType toWorkShiftType(WorkShiftTypeCreateRequest workShiftTypeCreateRequest) {
        return workShiftTypeMapper.toWorkShiftType(workShiftTypeCreateRequest);
    }
}
