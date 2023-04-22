package com.geo.easypoint.users.dto.response;

import com.geo.easypoint.employee.dto.response.EmployeeTableDto;

public record AuthenticationResponse(String username, String token, EmployeeTableDto employee) {
}
