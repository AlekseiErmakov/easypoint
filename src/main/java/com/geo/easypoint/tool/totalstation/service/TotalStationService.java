package com.geo.easypoint.tool.totalstation.service;

import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.tool.totalstation.domain.TotalStationRepository;
import com.geo.easypoint.tool.totalstation.web.TotalStationCreateRequestDto;
import com.geo.easypoint.tool.totalstation.web.TotalStationDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TotalStationService {

    private final TotalStationRepository repository;

    @Transactional
    public void createTotalStation(TotalStationCreateRequestDto createRequest) {
        repository.saveAndFlush(EasyPointMapper.toTotalStation(createRequest));
    }

    @Transactional(readOnly = true)
    public List<TotalStationDto> findAll() {
        return EasyPointMapper.toTotalStationDto(repository.findAll());
    }
}
