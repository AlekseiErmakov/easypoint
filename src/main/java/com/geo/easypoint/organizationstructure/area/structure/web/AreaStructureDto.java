package com.geo.easypoint.organizationstructure.area.structure.web;

import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeDto;
import java.util.List;

public record AreaStructureDto(Long id, String name, AreaStructureTypeDto areaStructureType, String description,
                               List<AreaStructureDto> children) {
}
