package com.geo.easypoint.iml.employee.controller;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeControllerTest extends AbstractAppTest {


    @BeforeEach
    public void clear() {
        employeeRepository.deleteAll();
    }

    @Test
    public void create() {
        EmployeeDto savedEmployee = employeeController.create(TestData.createEmployeeRequest());

        Assertions.assertThat(TestData.employeeDto())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(savedEmployee);
    }

    @Test
    public void findAllTest() {
        employeeRepository.save(TestData.employee());

        Assertions.assertThat(TestData.employeeDto())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(employeeController.findAll().get(0));
    }
}