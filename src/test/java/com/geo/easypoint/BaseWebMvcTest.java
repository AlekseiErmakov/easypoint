package com.geo.easypoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.easypoint.authentication.web.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

public abstract class BaseWebMvcTest {
    protected static final String CONTENT_TYPE = "application/json";
    @Autowired
    protected MockMvc webMvc;
    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    protected ObjectMapper objectMapper;
}
