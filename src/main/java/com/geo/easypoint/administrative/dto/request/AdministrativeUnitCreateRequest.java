package com.geo.easypoint.administrative.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdministrativeUnitCreateRequest(@NotBlank String name,
                                              @NotNull Long adminStructureTypeId,
                                              @NotNull String description,
                                              Long parentId) {
    public boolean isParentPresent() {
        return parentId != null;
    }
}
