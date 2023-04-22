package com.geo.easypoint.employee.service;

import com.geo.easypoint.administrative.dto.AdministrativeUnitDto;
import com.geo.easypoint.administrative.entity.AdministrativeUnit;
import com.geo.easypoint.administrative.repository.AdministrativeUnitRepository;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employee.dto.response.EmployeeTableDto;
import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AdministrativeUnitRepository administrativeUnitRepository;

    @Transactional(readOnly = true)
    public List<EmployeeTableDto> findAll() {
        return EasyPointMapper.toEmployeeDto(employeeRepository.findAll());
    }

    @Transactional
    public EmployeeTableDto create(CreateEmployeeRequest createEmployeeRequest) {
        List<AdministrativeUnit> administrativeUnits = administrativeUnitRepository.findAllById(createEmployeeRequest.adminStructures());
        Employee employee = employeeRepository.saveAndFlush(EasyPointMapper.toEmployee(createEmployeeRequest, administrativeUnits));
        return EasyPointMapper.toEmployeeDto(employee);
    }

    private List<AdministrativeUnitDto> findAllForEmployee(Employee employee) {
        Map<Long, AdministrativeUnitDto> adminDtos = new HashMap<>();
        Set<AdministrativeUnit> administrativeUnits = employee.getAdministrativeUnits();
        for (AdministrativeUnit administrativeUnit : administrativeUnits) {
            while (administrativeUnit != null) {
                adminDtos.put(administrativeUnit.getId(), EasyPointMapper.toAdministrativeUnitDto(administrativeUnit));
                administrativeUnit = administrativeUnit.getParent();
            }
        }
        return new ArrayList<>(adminDtos.values());
    }

}
