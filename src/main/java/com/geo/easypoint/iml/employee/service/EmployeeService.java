package com.geo.easypoint.iml.employee.service;

import com.geo.easypoint.api.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.iml.employee.repository.EmployeeRepository;
import com.geo.easypoint.iml.mapper.EasyPointMapper;
import com.geo.easypoint.iml.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> findAll() {
        return EasyPointMapper.toEmployeeDto(employeeRepository.findAll());
    }

    public Long create(CreateEmployeeRequest createEmployeeRequest) {
        return employeeRepository.save(EasyPointMapper.toEmployee(createEmployeeRequest))
                .getId();
    }
}
