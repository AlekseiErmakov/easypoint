package com.geo.easypoint.administrative.service;

import com.geo.easypoint.administrative.dto.AdminStructureTypeDto;
import com.geo.easypoint.administrative.dto.request.AdminStructureTypeCreateRequest;
import com.geo.easypoint.administrative.repository.AdminStructureTypeRepository;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminStructureTypeService {

    private final AdminStructureTypeRepository repository;

    @Transactional(readOnly = true)
    public List<AdminStructureTypeDto> findAll() {
        return EasyPointMapper.toAdminStructureDto(repository.findAll());
    }

    @Transactional
    public void create(AdminStructureTypeCreateRequest request) {
        repository.save(EasyPointMapper.toAdminStructure(request));
    }
}
