package com.geo.easypoint.area.dto.request;

public record AreaStructureCreateRequestDto(String name, Long areaStructureTypeId, String description, Long parentId) {
    public boolean isParentPresent() {
        return parentId != null;
    }
}
