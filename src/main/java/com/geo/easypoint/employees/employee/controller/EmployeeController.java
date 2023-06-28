package com.geo.easypoint.employees.employee.controller;

import com.geo.easypoint.employees.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employees.employee.dto.request.EmployeeUpdateRequest;
import com.geo.easypoint.employees.employee.dto.response.EmployeeDto;
import com.geo.easypoint.employees.employee.dto.response.EmployeeTableDto;
import com.geo.easypoint.employees.employee.service.EmployeeService;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeTableDto> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto findById(@Positive @PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeTableDto create(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return employeeService.create(createEmployeeRequest);
    }

    @PatchMapping("/{id}")
    public void update(@RequestBody EmployeeUpdateRequest employeeUpdateRequest, @Positive @PathVariable("id") Long id) {
        employeeService.updateEmployee(employeeUpdateRequest, id);
    }
}
