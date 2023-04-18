package com.geo.easypoint.point.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PointCreateRequestDto(@NotBlank String name,
                                    @NotNull BigDecimal x,
                                    @NotNull BigDecimal y,
                                    BigDecimal h,
                                    @NotNull @Positive Long pointTypeId,
                                    @NotNull @Positive Long pointAreaId) {
}
