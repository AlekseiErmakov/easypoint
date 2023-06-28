package com.geo.easypoint.authentication.web;

import com.geo.easypoint.employees.employee.dto.response.EmployeeTableDto;

public record AuthenticationResponse(String username, String token, EmployeeTableDto employee) {
}
