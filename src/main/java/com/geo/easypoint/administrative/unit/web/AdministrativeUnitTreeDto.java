package com.geo.easypoint.administrative.unit.web;

import com.geo.easypoint.administrative.unittype.web.AdministrativeUnitTypeDto;
import java.util.List;

public record AdministrativeUnitTreeDto(Long id, String name, AdministrativeUnitTypeDto adminStructureType,
                                        String description,
                                        List<AdministrativeUnitTreeDto> children) {
}
