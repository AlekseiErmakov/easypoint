package com.geo.easypoint.api.users.response;

import com.geo.easypoint.api.employee.dto.response.EmployeeDto;

public record AuthenticationResponse(String username, String token, EmployeeDto employee) {
}
