package com.geo.easypoint.administrative.service;

import com.geo.easypoint.administrative.dto.AdminDto;
import com.geo.easypoint.administrative.dto.AdminStructureDto;
import com.geo.easypoint.administrative.dto.request.AdminStructureCreateRequest;
import com.geo.easypoint.administrative.dto.request.AdminStructureTypeCreateRequest;
import com.geo.easypoint.administrative.entity.AdminStructure;
import com.geo.easypoint.administrative.repository.AdminStructureRepository;
import com.geo.easypoint.area.dto.AreaDto;
import com.geo.easypoint.area.dto.AreaStructureDto;
import com.geo.easypoint.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.area.entity.AreaStructure;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminStructureService {

    private final AdminStructureRepository adminStructureRepository;
    @Transactional(readOnly = true)
    public List<AdminStructureDto> findAll() {
        return EasyPointMapper.toAdminStructureDto(adminStructureRepository.findAllByParentIsNull());
    }

    @Transactional
    public void creteAreaStructure(AdminStructureCreateRequest request) {
        AdminStructure adminStructure;
        if (request.isParentPresent()) {
            adminStructure = EasyPointMapper.toAdminStructure(request, NotFoundException.orElseThrow(request.parentId(), AdminStructure.class, adminStructureRepository::findById));
        } else {
            adminStructure = EasyPointMapper.toAdminStructure(request);
        }
        adminStructureRepository.save(adminStructure);
    }

    @Transactional(readOnly = true)
    public List<AdminDto> findAllAdmins() {
        return EasyPointMapper.toAdminDto(adminStructureRepository.findAll());
    }

}
