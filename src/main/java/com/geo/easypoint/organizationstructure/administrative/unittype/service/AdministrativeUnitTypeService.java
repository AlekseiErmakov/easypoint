package com.geo.easypoint.organizationstructure.administrative.unittype.service;

import com.geo.easypoint.organizationstructure.administrative.unittype.domain.AdministrativeUnitType;
import com.geo.easypoint.organizationstructure.administrative.unittype.domain.AdministrativeUnitTypeRepository;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeCreateDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeUpdateDto;
import com.geo.easypoint.common.dictionary.service.DictionaryService;
import org.springframework.stereotype.Service;

@Service
public class AdministrativeUnitTypeService extends DictionaryService<AdministrativeUnitType, AdministrativeUnitTypeDto, AdministrativeUnitTypeCreateDto, AdministrativeUnitTypeUpdateDto> {

    public AdministrativeUnitTypeService(AdministrativeUnitTypeRepository repository, AdministrativeUnitTypeMapper mapper) {
        super(repository, mapper);
    }
}
