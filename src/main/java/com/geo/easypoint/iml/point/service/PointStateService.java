package com.geo.easypoint.iml.point.service;

import com.geo.easypoint.api.point.dto.PointStateDto;
import com.geo.easypoint.iml.mapper.EasyPointMapper;
import com.geo.easypoint.iml.point.repository.PointStateRepository;
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
