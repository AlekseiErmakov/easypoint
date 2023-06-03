package com.geo.easypoint.administrative.unit.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdministrativeUnitCreateDto(@NotBlank String name,
                                          @NotNull Long adminStructureTypeId,
                                          @NotNull String description,
                                          Long parentId) {
    public boolean isParentPresent() {
        return parentId != null;
    }
}
