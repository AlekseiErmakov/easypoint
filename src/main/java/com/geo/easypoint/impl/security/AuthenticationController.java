package com.geo.easypoint.impl.security;

import com.geo.easypoint.api.users.request.CreateUserRequest;
import com.geo.easypoint.api.users.request.LoginRequest;
import com.geo.easypoint.api.users.response.AuthenticationResponse;
import com.geo.easypoint.api.users.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody LoginRequest request) {
        return service.authenticate(request);
    }
}
