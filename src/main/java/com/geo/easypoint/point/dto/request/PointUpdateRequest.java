package com.geo.easypoint.point.dto.request;

import java.math.BigDecimal;

public record PointUpdateRequest(String name,
                                 BigDecimal x,
                                 BigDecimal y,
                                 BigDecimal h,
                                 Long pointTypeId,
                                 Long pointAreaId) {
}
