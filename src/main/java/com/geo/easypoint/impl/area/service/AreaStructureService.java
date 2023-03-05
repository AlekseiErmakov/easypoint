package com.geo.easypoint.impl.area.service;

import com.geo.easypoint.api.area.dto.AreaDto;
import com.geo.easypoint.api.area.dto.AreaStructureDto;
import com.geo.easypoint.api.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.api.area.dto.request.AreaStructureLinkRequest;
import com.geo.easypoint.impl.area.entity.AreaStructure;
import com.geo.easypoint.impl.area.repository.AreaStructureRepository;
import com.geo.easypoint.impl.exception.NotFoundException;
import com.geo.easypoint.impl.mapper.EasyPointMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AreaStructureService {

    private final AreaStructureRepository areaStructureRepository;

    @Transactional(readOnly = true)
    public List<AreaStructureDto> findAll() {
        return EasyPointMapper.toAreaStructureDto(areaStructureRepository.findAllByParentIsNull());
    }

    @Transactional
    public void creteAreaStructure(AreaStructureCreateRequestDto request) {
        log.info("Creating area Structure");
        AreaStructure areaStructure;
        if (request.isParentPresent()) {
            areaStructure = EasyPointMapper.toAreaStructureType(request, NotFoundException.orElseThrow(request.parentId(), AreaStructure.class, areaStructureRepository::findById));
        } else {
            areaStructure = EasyPointMapper.toAreaStructure(request);
        }
        areaStructureRepository.save(areaStructure);
    }

    @Transactional
    public void linkStructure(AreaStructureLinkRequest request) {
        AreaStructure child = NotFoundException.orElseThrow(request.childId(), AreaStructure.class, areaStructureRepository::findById);
        AreaStructure parent = NotFoundException.orElseThrow(request.parentId(), AreaStructure.class, areaStructureRepository::findById);
        parent.getChildren().add(child);
        child.setParent(parent);
        areaStructureRepository.save(child);
        areaStructureRepository.save(parent);
    }

    public List<AreaDto> findAllAreas() {
        return EasyPointMapper.toAreaDto(areaStructureRepository.findAll());
    }
}
