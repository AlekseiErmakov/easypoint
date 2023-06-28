package com.geo.easypoint.employees.competency.service;

import com.geo.easypoint.employees.competency.domain.Competency;
import com.geo.easypoint.employees.competency.domain.CompetencyRepository;
import com.geo.easypoint.employees.competency.web.CompetencyCreateDto;
import com.geo.easypoint.employees.competency.web.CompetencyDto;
import com.geo.easypoint.employees.competency.web.CompetencyUpdateDto;
import com.geo.easypoint.common.dictionary.service.BaseDictionaryService;
import com.geo.easypoint.employees.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class CompetencyService extends BaseDictionaryService<Competency, CompetencyDto, CompetencyCreateDto, CompetencyUpdateDto> {

    private final CompetencyRepository competencyRepository;
    private final EmployeeRepository employeeRepository;
    private final CompetencyMapper competencyMapper;

    public CompetencyService(CompetencyRepository competencyRepository, EmployeeRepository employeeRepository, CompetencyMapper competencyMapper) {
        super(competencyRepository, competencyMapper);
        this.competencyRepository = competencyRepository;
        this.employeeRepository = employeeRepository;
        this.competencyMapper = competencyMapper;
    }
}
