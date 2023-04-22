package com.geo.easypoint.tool.total.station.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TotalStationCreateRequestDto(@NotBlank String firm,
                                           @NotBlank String model,
                                           @NotBlank String serialNumber) {
}
