package com.geo.easypoint.workshifttype.service;

import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.workshifttype.web.WorkShiftTypeCreateRequest;
import com.geo.easypoint.workshifttype.web.WorkShiftTypeDto;
import com.geo.easypoint.workshifttype.domain.WorkShiftTypeRepository;
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
