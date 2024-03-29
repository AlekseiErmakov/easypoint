package com.geo.easypoint.justification.pointtype.service;

import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.justification.pointtype.domain.PointTypeRepository;
import com.geo.easypoint.justification.pointtype.web.PointTypeDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointTypeService {
    private final PointTypeRepository pointTypeRepository;

    public List<PointTypeDto> findAll() {

        return EasyPointMapper.toPointTypeDto(pointTypeRepository.findAll());
    }
}
