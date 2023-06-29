package com.geo.easypoint.employees.competency.web;

import com.geo.easypoint.employees.competency.domain.Competency;
import com.geo.easypoint.employees.competency.service.CompetencyService;
import com.geo.easypoint.common.dictionary.web.DictionaryController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competencies")
public class CompetencyController extends DictionaryController<Competency, CompetencyDto, CompetencyCreateDto, CompetencyUpdateDto> {

    public CompetencyController(CompetencyService competencyService) {
        super(competencyService);
    }

}
