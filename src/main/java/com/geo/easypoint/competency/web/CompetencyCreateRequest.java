package com.geo.easypoint.competency.web;

import jakarta.validation.constraints.NotBlank;

public record CompetencyCreateRequest(@NotBlank String name, @NotBlank String description) {
}
