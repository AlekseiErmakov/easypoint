package com.geo.easypoint.tool.totalstation.service;

import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.common.mapper.PartialUpdater;
import com.geo.easypoint.tool.totalstation.domain.TotalStation;
import com.geo.easypoint.tool.totalstation.domain.TotalStationRepository;
import com.geo.easypoint.tool.totalstation.web.TotalStationCreateRequestDto;
import com.geo.easypoint.tool.totalstation.web.TotalStationDto;
import com.geo.easypoint.tool.totalstation.web.TotalStationUpdateDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TotalStationService {

    private final TotalStationRepository repository;

    @Transactional
    public TotalStationDto createTotalStation(TotalStationCreateRequestDto createRequest) {
        return EasyPointMapper.toTotalStationDto(repository.saveAndFlush(EasyPointMapper.toTotalStation(createRequest)));
    }

    @Transactional
    public TotalStationDto updateTotalStation(TotalStationUpdateDto updateDto, Long id) {
        TotalStation totalStation = repository.findById(id)
                .orElseThrow(() -> new EasyPointNotFoundException(id, TotalStation.class));
        PartialUpdater.updater()
                .update(updateDto.firm(), totalStation::setFirm)
                .update(updateDto.model(), totalStation::setModel)
                .update(updateDto.serialNumber(), totalStation::setSerialNumber);
        return EasyPointMapper.toTotalStationDto(repository.save(totalStation));
    }

    @Transactional
    public void delete(Long id) {
        TotalStation totalStation = repository.findById(id)
                .orElseThrow(() -> new EasyPointNotFoundException(id, TotalStation.class));
        repository.delete(totalStation);
    }

    @Transactional(readOnly = true)
    public List<TotalStationDto> findAll() {
        return EasyPointMapper.toTotalStationDto(repository.findAll());
    }
}
