package com.geo.easypoint.iml.mapper;

import com.geo.easypoint.api.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.api.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.iml.employee.entity.Employee;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeDto toEmployeeDto(Employee employee);
    Employee toEmployee(CreateEmployeeRequest createEmployeeRequest);
    List<EmployeeDto> toEmployeeDto(Collection<Employee> employees);
}
