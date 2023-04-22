package com.geo.easypoint.employee.service;

import com.geo.easypoint.common.PartialUpdater;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.employee.dto.CompetencyDto;
import com.geo.easypoint.employee.dto.request.CompetencyCreateRequest;
import com.geo.easypoint.employee.dto.request.CompetencyPartialUpdateRequest;
import com.geo.easypoint.employee.entity.Competency;
import com.geo.easypoint.employee.repository.CompetencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetencyService {

    private final CompetencyRepository competencyRepository;

    @Transactional
    public void createCompetency(CompetencyCreateRequest request) {
        competencyRepository.save(EasyPointMapper.toCompetency(request));
    }

    @Transactional
    public void updateCompetency(CompetencyPartialUpdateRequest request, Long id) {
        Competency competency = NotFoundException.orElseThrow(id, Competency.class, competencyRepository::findById);
        PartialUpdater.updater()
                .update(request.name(), competency::setName)
                .update(request.description(), competency::setDescription);
        competencyRepository.save(competency);
    }

    @Transactional(readOnly = true)
    public List<CompetencyDto> findAll() {
        return EasyPointMapper.toCompetencyDto(competencyRepository.findAll());
    }
}
