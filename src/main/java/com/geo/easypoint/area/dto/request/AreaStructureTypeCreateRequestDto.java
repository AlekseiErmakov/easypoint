package com.geo.easypoint.area.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AreaStructureTypeCreateRequestDto(@NotBlank String name,
                                                String description) {
}
