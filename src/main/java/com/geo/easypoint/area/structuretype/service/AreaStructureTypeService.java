package com.geo.easypoint.area.structuretype.service;

import com.geo.easypoint.area.structuretype.domain.AreaStructureTypeRepository;
import com.geo.easypoint.area.structuretype.web.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.area.structuretype.web.AreaStructureTypeDto;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
