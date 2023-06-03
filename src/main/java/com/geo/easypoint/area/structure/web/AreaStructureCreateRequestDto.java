package com.geo.easypoint.area.structure.web;

import jakarta.validation.constraints.NotBlank;

public record AreaStructureCreateRequestDto(@NotBlank String name,
                                            @NotBlank Long areaStructureTypeId,
                                            @NotBlank String description,
                                            Long parentId) {
    public boolean isParentPresent() {
        return parentId != null;
    }
}
