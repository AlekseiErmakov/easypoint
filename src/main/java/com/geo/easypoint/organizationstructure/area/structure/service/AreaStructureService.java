package com.geo.easypoint.organizationstructure.area.structure.service;

import com.geo.easypoint.organizationstructure.area.structure.domain.AreaStructure;
import com.geo.easypoint.organizationstructure.area.structure.domain.AreaStructureRepository;
import com.geo.easypoint.organizationstructure.area.structure.web.AreaDto;
import com.geo.easypoint.organizationstructure.area.structure.web.AreaStructureCreateRequestDto;
import com.geo.easypoint.organizationstructure.area.structure.web.AreaStructureDto;
import com.geo.easypoint.organizationstructure.area.structure.web.AreaStructureLinkRequest;
import com.geo.easypoint.organizationstructure.area.structuretype.domain.AreaStructureTypeRepository;
import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                    EasyPointNotFoundException.orElseThrow(request.parentId(), AreaStructure.class, areaStructureRepository::findById),
                    EasyPointNotFoundException.orElseThrow(request.areaStructureTypeId(), AreaStructure.class, areaStructureTypeRepository::findById)
            );
        } else {
            areaStructure = EasyPointMapper.toAreaStructure(request,
                    EasyPointNotFoundException.orElseThrow(request.areaStructureTypeId(), AreaStructure.class, areaStructureTypeRepository::findById));
        }
        areaStructureRepository.save(areaStructure);
    }

    @Transactional
    public void linkStructure(AreaStructureLinkRequest request) {
        AreaStructure child = EasyPointNotFoundException.orElseThrow(request.childId(), AreaStructure.class, areaStructureRepository::findById);
        AreaStructure parent = EasyPointNotFoundException.orElseThrow(request.parentId(), AreaStructure.class, areaStructureRepository::findById);
        parent.getChildren().add(child);
        child.setParent(parent);
        areaStructureRepository.save(child);
        areaStructureRepository.save(parent);
    }

    public List<AreaDto> findAllAreas() {
        return EasyPointMapper.toAreaDto(areaStructureRepository.findAll());
    }
}
