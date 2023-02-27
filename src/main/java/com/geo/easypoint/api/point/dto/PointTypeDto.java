package com.geo.easypoint.api.point.dto;

import com.geo.easypoint.iml.point.entity.PointTypes;

public record PointTypeDto(Long id, PointTypes code, String name, String description) {
}
