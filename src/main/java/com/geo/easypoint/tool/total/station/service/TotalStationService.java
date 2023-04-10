package com.geo.easypoint.tool.total.station.service;

import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.tool.total.station.dto.TotalStationDto;
import com.geo.easypoint.tool.total.station.dto.request.TotalStationCreateRequestDto;
import com.geo.easypoint.tool.total.station.entity.TotalStation;
import com.geo.easypoint.tool.total.station.repository.TotalStationRepository;
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
    }

    @Transactional(readOnly = true)
    public List<TotalStationDto> findAll() {
        return EasyPointMapper.toTotalStationDto(repository.findAll());
    }
}
