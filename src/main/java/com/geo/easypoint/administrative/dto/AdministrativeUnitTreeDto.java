package com.geo.easypoint.administrative.dto;

import java.util.List;

public record AdministrativeUnitTreeDto(Long id, String name, AdministrativeUnitTypeDto adminStructureType,
                                        String description,
                                        List<AdministrativeUnitTreeDto> children) {
}
