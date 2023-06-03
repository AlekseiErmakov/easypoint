package com.geo.easypoint.authentication.web;

import com.geo.easypoint.employee.dto.response.EmployeeTableDto;

public record AuthenticationResponse(String username, String token, EmployeeTableDto employee) {
}
