package com.geo.easypoint.api.area.dto;

import java.util.List;

public record AreaStructureDto(Long id, String name, AreaStructureTypeDto areaStructureType, String description,
                               List<AreaStructureDto> children) {
}
