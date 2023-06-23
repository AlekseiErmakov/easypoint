package com.geo.easypoint.administrative.unittype.service;

import com.geo.easypoint.administrative.unittype.domain.AdministrativeUnitTypeRepository;
import com.geo.easypoint.administrative.unittype.web.AdministrativeUnitTypeCreateRequest;
import com.geo.easypoint.administrative.unittype.web.AdministrativeUnitTypeDto;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdministrativeUnitTypeService {

    private final AdministrativeUnitTypeRepository repository;

    @Transactional(readOnly = true)
    public List<AdministrativeUnitTypeDto> findAll() {
        return EasyPointMapper.toAdministrativeUnitTypeDto(repository.findAll());
    }

    @Transactional
    public void create(AdministrativeUnitTypeCreateRequest request) {
        repository.save(EasyPointMapper.toAdministrativeUnitType(request));
    }
}
