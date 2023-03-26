package com.geo.easypoint.employee.service;

import com.geo.easypoint.administrative.entity.AdminStructure;
import com.geo.easypoint.administrative.repository.AdminStructureRepository;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employee.dto.response.EmployeeDto;
import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AdminStructureRepository adminStructureRepository;

    @Transactional(readOnly = true)
    public List<EmployeeDto> findAll() {
        return EasyPointMapper.toEmployeeDto(employeeRepository.findAll());
    }

    @Transactional
    public EmployeeDto create(CreateEmployeeRequest createEmployeeRequest) {
        List<AdminStructure> adminStructures = adminStructureRepository.findAllById(createEmployeeRequest.adminStructures());
        Employee employee = employeeRepository.saveAndFlush(EasyPointMapper.toEmployee(createEmployeeRequest, adminStructures));
        return EasyPointMapper.toEmployeeDto(employee);
    }
}
