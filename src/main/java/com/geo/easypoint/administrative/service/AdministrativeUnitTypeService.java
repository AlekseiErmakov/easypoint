package com.geo.easypoint.administrative.service;

import com.geo.easypoint.administrative.dto.AdministrativeUnitTypeDto;
import com.geo.easypoint.administrative.dto.request.AdministrativeUnitTypeCreateRequest;
import com.geo.easypoint.administrative.repository.AdministrativeUnitTypeRepository;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
