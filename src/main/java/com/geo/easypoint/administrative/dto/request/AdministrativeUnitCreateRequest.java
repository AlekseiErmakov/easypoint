package com.geo.easypoint.administrative.dto.request;

public record AdministrativeUnitCreateRequest(String name, Long adminStructureTypeId, String description, Long parentId) {
    public boolean isParentPresent() {
        return parentId != null;
    }
}
