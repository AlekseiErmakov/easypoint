package com.geo.easypoint.pointtype.web;

import com.geo.easypoint.pointstate.domain.PointTypes;

public record PointTypeDto(Long id, PointTypes code, String name, String description) {
}
