package com.geo.easypoint.organizationstructure.administrative.unit.web;

import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeDto;
import java.util.List;

public record AdministrativeUnitTreeDto(Long id, String name, AdministrativeUnitTypeDto adminStructureType,
                                        String description,
                                        List<AdministrativeUnitTreeDto> children) {
}
