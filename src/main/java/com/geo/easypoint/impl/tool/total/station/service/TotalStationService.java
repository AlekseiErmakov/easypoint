package com.geo.easypoint.impl.tool.total.station.service;

import com.geo.easypoint.api.tool.total.station.TotalStationDto;
import com.geo.easypoint.api.tool.total.station.request.TotalStationCreateRequestDto;
import com.geo.easypoint.impl.mapper.EasyPointMapper;
import com.geo.easypoint.impl.tool.total.station.entity.TotalStation;
import com.geo.easypoint.impl.tool.total.station.repository.TotalStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TotalStationService {

    private final TotalStationRepository repository;

    @Transactional
    public void createTotalStation(TotalStationCreateRequestDto createRequest) {
        TotalStation save = repository.saveAndFlush(EasyPointMapper.toTotalStation(createRequest));
        System.out.println();

    }

    @Transactional(readOnly = true)
    public List<TotalStationDto> findAll() {
        return EasyPointMapper.toTotalStationDto(repository.findAll());
    }
}
