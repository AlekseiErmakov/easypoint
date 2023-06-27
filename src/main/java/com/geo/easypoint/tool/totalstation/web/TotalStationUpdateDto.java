package com.geo.easypoint.tool.totalstation.web;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.openapitools.jackson.nullable.JsonNullable;

@Builder
public record TotalStationUpdateDto(JsonNullable<String> firm,
                                    JsonNullable<String> model,
                                    JsonNullable<String> serialNumber) {
}
