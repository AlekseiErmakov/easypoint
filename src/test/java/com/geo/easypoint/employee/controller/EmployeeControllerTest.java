package com.geo.easypoint.employee.controller;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.employee.dto.response.EmployeeDto;
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
                .ignoringFields("id", "created", "updated")
                .isEqualTo(savedEmployee);
        Assertions.assertThat(savedEmployee.id())
                .isNotNull();
        Assertions.assertThat(savedEmployee.created())
                .isNotNull();
        Assertions.assertThat(savedEmployee.updated())
                .isNotNull();
    }

    @Test
    public void findAllTest() {
        employeeRepository.save(TestData.employee());

        Assertions.assertThat(TestData.employeeDto())
                .usingRecursiveComparison()
                .ignoringFields("id", "created", "updated")
                .isEqualTo(employeeController.findAll().get(0));
    }
}