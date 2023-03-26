package com.geo.easypoint.area.service;

import com.geo.easypoint.area.dto.AreaDto;
import com.geo.easypoint.area.dto.AreaStructureDto;
import com.geo.easypoint.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.area.dto.request.AreaStructureLinkRequest;
import com.geo.easypoint.area.entity.AreaStructure;
import com.geo.easypoint.area.repository.AreaStructureRepository;
import com.geo.easypoint.area.repository.AreaStructureTypeRepository;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
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
    private final AreaStructureTypeRepository areaStructureTypeRepository;

    @Transactional(readOnly = true)
    public List<AreaStructureDto> findAll() {
        return EasyPointMapper.toAreaStructureDto(areaStructureRepository.findAllByParentIsNull());
    }

    @Transactional
    public void creteAreaStructure(AreaStructureCreateRequestDto request) {
        log.info("Creating area Structure");
        AreaStructure areaStructure;
        if (request.isParentPresent()) {
            areaStructure = EasyPointMapper.toAreaStructure(request,
                    NotFoundException.orElseThrow(request.parentId(), AreaStructure.class, areaStructureRepository::findById),
                    NotFoundException.orElseThrow(request.areaStructureTypeId(), AreaStructure.class, areaStructureTypeRepository::findById)
            );
        } else {
            areaStructure = EasyPointMapper.toAreaStructure(request,
                    NotFoundException.orElseThrow(request.areaStructureTypeId(), AreaStructure.class, areaStructureTypeRepository::findById));
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
