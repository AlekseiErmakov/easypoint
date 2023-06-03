package com.geo.easypoint.tool.totalstation.web;

import jakarta.validation.constraints.NotBlank;

public record TotalStationCreateRequestDto(@NotBlank String firm,
                                           @NotBlank String model,
                                           @NotBlank String serialNumber) {
}
