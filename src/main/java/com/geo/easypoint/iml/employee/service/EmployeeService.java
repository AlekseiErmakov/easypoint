package com.geo.easypoint.iml.employee.service;

import com.geo.easypoint.api.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.iml.employee.repository.EmployeeRepository;
import com.geo.easypoint.iml.mapper.EasyPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<EmployeeDto> findAll() {
        return EasyPointMapper.toEmployeeDto(employeeRepository.findAll());
    }

    @Transactional
    public EmployeeDto create(CreateEmployeeRequest createEmployeeRequest) {
        return EasyPointMapper.toEmployeeDto(
                employeeRepository.saveAndFlush(EasyPointMapper.toEmployee(createEmployeeRequest))
        );
    }
}
