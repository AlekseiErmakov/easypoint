package com.geo.easypoint.iml.mapper;

import com.geo.easypoint.api.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.iml.employee.entity.Employee;
import com.geo.easypoint.iml.utill.CollectionUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EasyPointMapper {
    private static final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return employeeMapper.toEmployeeDto(employee);
    }

    public static List<EmployeeDto> toEmployeeDto(Collection<Employee> employees) {
        return CollectionUtils.mapToList(employees, EasyPointMapper::toEmployeeDto);
    }

    public static Employee toEmployee(CreateEmployeeRequest createEmployeeRequest){
        return employeeMapper.toEmployee(createEmployeeRequest);
    }
}
