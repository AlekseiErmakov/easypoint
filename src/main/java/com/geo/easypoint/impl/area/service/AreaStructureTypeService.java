package com.geo.easypoint.impl.area.service;

import com.geo.easypoint.api.area.dto.AreaStructureTypeDto;
import com.geo.easypoint.api.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.api.area.dto.request.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.impl.area.repository.AreaStructureRepository;
import com.geo.easypoint.impl.area.repository.AreaStructureTypeRepository;
import com.geo.easypoint.impl.mapper.EasyPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaStructureTypeService {

    private final AreaStructureTypeRepository areaStructureTypeRepository;

    @Transactional
    public List<AreaStructureTypeDto> findAll() {
        return EasyPointMapper.toAreaStructureTypeDto(areaStructureTypeRepository.findAll());
    }

    @Transactional
    public void create(AreaStructureTypeCreateRequestDto createRequestDto) {
        areaStructureTypeRepository.save(EasyPointMapper.toAreaStructureType(createRequestDto));
    }
}
