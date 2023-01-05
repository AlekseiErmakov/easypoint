package com.geo.easypoint.iml.employee.controller;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.iml.employee.entity.Employee;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class EmployeeControllerTest extends AbstractAppTest {


    @Test
    public void create() {
        Long lastSavedId = employeeRepository.findAll()
                .stream()
                .max(Comparator.comparing(Employee::getId))
                .map(Employee::getId)
                .orElse(0L);
        Long savedId = employeeController.create(TestData.createEmployeeRequest());
        EmployeeDto employeeDto = employeeController.findAll()
                .stream()
                .filter(it -> savedId.longValue() == it.id())
                .findFirst()
                .get();

        Assertions.assertThat(savedId)
                .isEqualTo(lastSavedId + 1);

        Assertions.assertThat(TestData.employeeDto())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(employeeDto);
    }
}