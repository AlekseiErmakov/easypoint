package com.geo.easypoint.users.dto.response;

import com.geo.easypoint.employee.dto.response.EmployeeDto;

public record AuthenticationResponse(String username, String token, EmployeeDto employee) {
}
