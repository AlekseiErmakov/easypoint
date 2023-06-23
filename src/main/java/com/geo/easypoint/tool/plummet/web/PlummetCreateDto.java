package com.geo.easypoint.tool.plummet.web;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record PlummetCreateDto(@NotBlank String name) {
}
