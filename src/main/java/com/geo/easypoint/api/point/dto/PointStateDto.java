package com.geo.easypoint.api.point.dto;

import com.geo.easypoint.iml.point.entity.PointStates;

public record PointStateDto(Long id, PointStates code, String name, String description) {
}
