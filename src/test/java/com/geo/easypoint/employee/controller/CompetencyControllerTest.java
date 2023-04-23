package com.geo.easypoint.employee.controller;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.employee.dto.CompetencyDto;
import com.geo.easypoint.employee.dto.request.CompetencyCreateRequest;
import com.geo.easypoint.employee.entity.Competency;
import com.geo.easypoint.employee.entity.JobTitle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompetencyControllerTest extends AbstractAppTest {

    @BeforeEach
    public void init() {
        competencyRepository.deleteAll();
    }

    @Test
    void createCompetency() {
        competencyController.createCompetency(TestData.competencyCreateRequest());
        Competency competency = competencyRepository.findAll().iterator().next();

        Assertions.assertThat(competency)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(TestData.competency());

        Assertions.assertThat(competency.getId())
                .isNotNull();
    }

    @Test
    void updateCompetency() {
        Competency saved = competencyRepository.save(Competency.builder()
                .name("")
                .description("")
                .build());
        competencyController.updateCompetency(TestData.competencyPartialUpdateRequest(), saved.getId());

        Competency updated = competencyRepository.findAll().iterator().next();

        Assertions.assertThat(updated)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(TestData.competency());

        Assertions.assertThat(updated.getId())
                .isEqualTo(saved.getId());
    }

    @Test
    void deleteCompetency() {
        Competency competency = competencyRepository.save(TestData.competency());

        competencyController.deleteCompetency(competency.getId());

        Assertions.assertThat(competencyRepository.findAll())
                .isEmpty();
    }

    @Test
    void findAll() {
        Competency saved = competencyRepository.save(TestData.competency());
        CompetencyDto competencyDto = competencyController.findAll().iterator().next();

        Assertions.assertThat(competencyDto)
                .usingRecursiveComparison()
                .isEqualTo(saved);
    }
}