package com.geo.easypoint.organizationstructure.area.structuretype.web;

import com.geo.easypoint.organizationstructure.area.structuretype.domain.AreaStructureType;
import com.geo.easypoint.organizationstructure.area.structuretype.service.AreaStructureTypeService;
import com.geo.easypoint.common.dictionary.web.BaseDictionaryController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area-structure-types")
public class AreaStructureTypeController extends BaseDictionaryController<AreaStructureType, AreaStructureTypeDto, AreaStructureTypeCreateDto, AreaStructureTypeUpdateDto> {

    public AreaStructureTypeController(AreaStructureTypeService areaStructureTypeService) {
        super(areaStructureTypeService);
    }
}
