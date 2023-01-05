package com.geo.easypoint;

import com.geo.easypoint.api.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.iml.employee.entity.Employee;

public final class TestData {

    public static final Long EMPLOYEE_ID = 1L;
    public static final String FIRSTNAME = "firstname";
    public static final String SURNAME = "surname";
    public static final String MIDDLE_NAME = "middle name";

    private TestData() {
    }

    public static Employee employee() {
        return Employee.builder()
                .id(EMPLOYEE_ID)
                .firstname(FIRSTNAME)
                .middlename(MIDDLE_NAME)
                .surname(SURNAME)
                .build();
    }

    public static EmployeeDto employeeDto() {
        return new EmployeeDto(EMPLOYEE_ID, FIRSTNAME, SURNAME, MIDDLE_NAME);
    }

    public static CreateEmployeeRequest createEmployeeRequest() {
        return new CreateEmployeeRequest(FIRSTNAME,SURNAME, MIDDLE_NAME);
    }
}
