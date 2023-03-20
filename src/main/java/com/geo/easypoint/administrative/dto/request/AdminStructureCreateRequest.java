package com.geo.easypoint.administrative.dto.request;

public record AdminStructureCreateRequest(String name, Long adminStructureTypeId, String description, Long parentId) {
    public boolean isParentPresent() {
        return parentId != null;
    }
}
