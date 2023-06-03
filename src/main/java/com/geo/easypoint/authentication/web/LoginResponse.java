package com.geo.easypoint.authentication.web;

public record LoginResponse(
        String login,
        String token
) {
}
