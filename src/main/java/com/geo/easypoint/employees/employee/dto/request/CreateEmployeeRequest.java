package com.geo.easypoint.employees.employee.dto.request;

import java.util.List;

public record CreateEmployeeRequest(String firstname, String surname, String lastname, List<Long> adminStructures) {

}
