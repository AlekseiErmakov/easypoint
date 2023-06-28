package com.geo.easypoint.justification.pointstate.service;

import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.justification.pointstate.domain.PointStateRepository;
import com.geo.easypoint.justification.pointstate.web.PointStateDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointStateService {

    private final PointStateRepository repository;

    public List<PointStateDto> findAll() {
        return EasyPointMapper.toPointStateDto(repository.findAll());
    }
}
