package com.geo.easypoint.authentication.web;

public record CreateUserRequest(
        String username,
        String password,
        Long employeeId
) {
}
