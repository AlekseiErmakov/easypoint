package com.geo.easypoint.organizationstructure.administrative.unit.service;

import com.geo.easypoint.organizationstructure.administrative.unit.domain.AdministrativeUnit;
import com.geo.easypoint.organizationstructure.administrative.unit.domain.AdministrativeUnitRepository;
import com.geo.easypoint.organizationstructure.administrative.unit.web.AdministrativeUnitCreateDto;
import com.geo.easypoint.organizationstructure.administrative.unit.web.AdministrativeUnitDto;
import com.geo.easypoint.organizationstructure.administrative.unit.web.AdministrativeUnitTreeDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.domain.AdministrativeUnitType;
import com.geo.easypoint.organizationstructure.administrative.unittype.domain.AdministrativeUnitTypeRepository;
import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdministrativeUnitService {

    private final AdministrativeUnitRepository administrativeUnitRepository;
    private final AdministrativeUnitTypeRepository administrativeUnitTypeRepository;

    @Transactional(readOnly = true)
    public List<AdministrativeUnitTreeDto> findAll() {
        return EasyPointMapper.toAdministrativeUnitTreeDto(administrativeUnitRepository.findAllByParentIsNull());
    }

    @Transactional
    public void creteAreaStructure(AdministrativeUnitCreateDto request) {
        AdministrativeUnit administrativeUnit;
        if (request.isParentPresent()) {
            administrativeUnit = EasyPointMapper.toAdministrativeUnit(request,
                    EasyPointNotFoundException.orElseThrow(request.parentId(), AdministrativeUnit.class, administrativeUnitRepository::findById),
                    EasyPointNotFoundException.orElseThrow(request.adminStructureTypeId(), AdministrativeUnitType.class, administrativeUnitTypeRepository::findById));
        } else {
            administrativeUnit = EasyPointMapper.toAdministrativeUnit(request,
                    EasyPointNotFoundException.orElseThrow(request.adminStructureTypeId(), AdministrativeUnitType.class, administrativeUnitTypeRepository::findById));
        }
        administrativeUnitRepository.save(administrativeUnit);
    }

    @Transactional(readOnly = true)
    public List<AdministrativeUnitDto> findAllAdmins() {
        return EasyPointMapper.toAdministrativeUnitDto(administrativeUnitRepository.findAll());
    }

}
