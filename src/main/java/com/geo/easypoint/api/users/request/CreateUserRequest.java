package com.geo.easypoint.api.users.request;

public record CreateUserRequest(
        String username,
        String password,
        Long employeeId
) {
}
