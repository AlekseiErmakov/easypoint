package com.geo.easypoint;

import com.geo.easypoint.api.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.iml.employee.entity.Employee;

import java.time.LocalDateTime;

public final class TestData {

    public static final Long EMPLOYEE_ID = 1L;
    public static final String FIRSTNAME = "firstname";
    public static final String SURNAME = "surname";
    public static final String MIDDLE_NAME = "middle name";
    public static final LocalDateTime CREATED = LocalDateTime.now();
    public static final LocalDateTime UPDATED = LocalDateTime.now();

    private TestData() {
    }

    public static Employee employee() {
        return Employee.builder()
                .id(EMPLOYEE_ID)
                .firstname(FIRSTNAME)
                .lastname(MIDDLE_NAME)
                .surname(SURNAME)
                .created(CREATED)
                .updated(UPDATED)
                .build();
    }

    public static EmployeeDto employeeDto() {
        return new EmployeeDto(EMPLOYEE_ID, FIRSTNAME, SURNAME, MIDDLE_NAME, CREATED, UPDATED);
    }

    public static CreateEmployeeRequest createEmployeeRequest() {
        return new CreateEmployeeRequest(FIRSTNAME,SURNAME, MIDDLE_NAME);
    }
}
