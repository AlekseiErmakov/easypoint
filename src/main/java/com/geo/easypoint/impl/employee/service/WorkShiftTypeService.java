package com.geo.easypoint.impl.employee.service;

import com.geo.easypoint.api.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.api.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.impl.employee.repository.WorkShiftTypeRepository;
import com.geo.easypoint.impl.mapper.EasyPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkShiftTypeService {

    private final WorkShiftTypeRepository workShiftTypeRepository;

    @Transactional(readOnly = true)
    public List<WorkShiftTypeDto> findAll() {
        return EasyPointMapper.toWorkShiftTypeDto(workShiftTypeRepository.findAll());
    }

    @Transactional
    public WorkShiftTypeDto save(WorkShiftTypeCreateRequest workShiftTypeCreateRequest) {
        return EasyPointMapper.toWorkShiftTypeDto(
                workShiftTypeRepository.saveAndFlush(EasyPointMapper.toWorkShiftType(workShiftTypeCreateRequest))
        );
    }
}
