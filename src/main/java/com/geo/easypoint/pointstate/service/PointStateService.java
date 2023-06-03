package com.geo.easypoint.pointstate.service;

import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.pointstate.web.PointStateDto;
import com.geo.easypoint.pointstate.domain.PointStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointStateService {

    private final PointStateRepository repository;

    public List<PointStateDto> findAll() {
        return EasyPointMapper.toPointStateDto(repository.findAll());
    }
}
