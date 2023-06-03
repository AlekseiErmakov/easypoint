package com.geo.easypoint.area.structuretype.web;

import jakarta.validation.constraints.NotBlank;

public record AreaStructureTypeCreateRequestDto(@NotBlank String name,
                                                String description) {
}
