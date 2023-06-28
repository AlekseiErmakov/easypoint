package com.geo.easypoint.organizationstructure.administrative.unittype.web;

import com.geo.easypoint.organizationstructure.administrative.unittype.domain.AdministrativeUnitType;
import com.geo.easypoint.organizationstructure.administrative.unittype.service.AdministrativeUnitTypeService;
import com.geo.easypoint.common.dictionary.web.BaseDictionaryController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrative-unit-types")
public class AdministrativeUnitTypeController extends BaseDictionaryController<AdministrativeUnitType, AdministrativeUnitTypeDto, AdministrativeUnitTypeCreateDto, AdministrativeUnitTypeUpdateDto> {

    public AdministrativeUnitTypeController(AdministrativeUnitTypeService administrativeUnitTypeService) {
        super(administrativeUnitTypeService);
    }
}
