package com.geo.easypoint.employee.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CompetencyCreateRequest(@NotBlank String name, @NotBlank String description) {
}
