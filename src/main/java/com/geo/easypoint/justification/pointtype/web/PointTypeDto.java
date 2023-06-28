package com.geo.easypoint.justification.pointtype.web;

import com.geo.easypoint.justification.pointtype.domain.PointTypes;

public record PointTypeDto(Long id, PointTypes code, String name, String description) {
}
