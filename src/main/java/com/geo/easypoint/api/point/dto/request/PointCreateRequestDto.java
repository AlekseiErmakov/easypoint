package com.geo.easypoint.api.point.dto.request;

import java.math.BigDecimal;

public record PointCreateRequestDto(String name, BigDecimal x, BigDecimal y, BigDecimal h) {
}
