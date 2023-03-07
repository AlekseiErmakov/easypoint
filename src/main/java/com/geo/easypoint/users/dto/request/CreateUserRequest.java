package com.geo.easypoint.users.dto.request;

public record CreateUserRequest(
        String username,
        String password,
        Long employeeId
) {
}
