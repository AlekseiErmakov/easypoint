package com.geo.easypoint.competency.service;

import com.geo.easypoint.common.mapper.PartialUpdater;
import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.employee.dto.CompetencyDto;
import com.geo.easypoint.competency.web.CompetencyCreateRequest;
import com.geo.easypoint.competency.web.CompetencyPartialUpdateRequest;
import com.geo.easypoint.competency.domain.Competency;
import com.geo.easypoint.competency.domain.CompetencyRepository;
import com.geo.easypoint.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetencyService {

    private final CompetencyRepository competencyRepository;
    private final EmployeeRepository employeeRepository;

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

    @Transactional
    public void deleteCompetency(Long id) {
        Competency competency = NotFoundException.orElseThrow(id, Competency.class, competencyRepository::findById);
        if (employeeRepository.existsByCompetency_Id(id)) {
            throw new EasyPointLogicException(
                    String.format("Competency %s can't be deleted, there are employees with this competency still",
                            competency.getName())
            );
        }
        competencyRepository.delete(competency);
    }

    @Transactional(readOnly = true)
    public List<CompetencyDto> findAll() {
        return EasyPointMapper.toCompetencyDto(competencyRepository.findAll());
    }
}
