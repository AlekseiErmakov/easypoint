package com.geo.easypoint.administrative.service;

import com.geo.easypoint.administrative.dto.AdministrativeUnitDto;
import com.geo.easypoint.administrative.dto.AdministrativeUnitTreeDto;
import com.geo.easypoint.administrative.dto.request.AdministrativeUnitCreateRequest;
import com.geo.easypoint.administrative.entity.AdministrativeUnit;
import com.geo.easypoint.administrative.entity.AdministrativeUnitType;
import com.geo.easypoint.administrative.repository.AdministrativeUnitRepository;
import com.geo.easypoint.administrative.repository.AdministrativeUnitTypeRepository;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void creteAreaStructure(AdministrativeUnitCreateRequest request) {
        AdministrativeUnit administrativeUnit;
        if (request.isParentPresent()) {
            administrativeUnit = EasyPointMapper.toAdministrativeUnit(request,
                    NotFoundException.orElseThrow(request.parentId(), AdministrativeUnit.class, administrativeUnitRepository::findById),
                    NotFoundException.orElseThrow(request.adminStructureTypeId(), AdministrativeUnitType.class, administrativeUnitTypeRepository::findById));
        } else {
            administrativeUnit = EasyPointMapper.toAdministrativeUnit(request,
                    NotFoundException.orElseThrow(request.adminStructureTypeId(), AdministrativeUnitType.class, administrativeUnitTypeRepository::findById));
        }
        administrativeUnitRepository.save(administrativeUnit);
    }

    @Transactional(readOnly = true)
    public List<AdministrativeUnitDto> findAllAdmins() {
        return EasyPointMapper.toAdministrativeUnitDto(administrativeUnitRepository.findAll());
    }

}
