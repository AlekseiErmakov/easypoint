package com.geo.easypoint.organizationstructure.area.structuretype.service;

import com.geo.easypoint.organizationstructure.area.structuretype.domain.AreaStructureType;
import com.geo.easypoint.organizationstructure.area.structuretype.domain.AreaStructureTypeRepository;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeCreateDto;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeDto;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeUpdateDto;
import com.geo.easypoint.common.dictionary.service.BaseDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class AreaStructureTypeService extends BaseDictionaryService<AreaStructureType, AreaStructureTypeDto, AreaStructureTypeCreateDto, AreaStructureTypeUpdateDto> {

    public AreaStructureTypeService(AreaStructureTypeRepository repository, AreaStructureTypeMapper mapper) {
        super(repository, mapper);
    }
}
