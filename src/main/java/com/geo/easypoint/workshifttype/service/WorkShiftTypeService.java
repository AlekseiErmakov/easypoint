package com.geo.easypoint.workshifttype.service;

import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.workshifttype.domain.WorkShiftTypeRepository;
import com.geo.easypoint.workshifttype.web.WorkShiftTypeCreateRequest;
import com.geo.easypoint.workshifttype.web.WorkShiftTypeDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
