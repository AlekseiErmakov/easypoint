package com.geo.easypoint.employee.controller;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.employees.competency.web.CompetencyDto;
import com.geo.easypoint.employees.competency.domain.Competency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CompetencyControllerTest extends AbstractAppTest {

    @BeforeEach
    public void init() {
        competencyRepository.deleteAllInBatch();
    }

    @Test
    void createCompetency() {
        competencyController.create(TestData.competencyCreateRequest());
        Competency competency = competencyRepository.findAll().iterator().next();

        Assertions.assertThat(competency)
                .usingRecursiveComparison()
                .ignoringFields("id", "created", "updated")
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
        competencyController.update(TestData.competencyPartialUpdateRequest(), saved.getId());

        Competency updated = competencyRepository.findAll().iterator().next();

        Assertions.assertThat(updated)
                .usingRecursiveComparison()
                .ignoringFields("id", "created", "updated")
                .isEqualTo(TestData.competency());

        Assertions.assertThat(updated.getId())
                .isEqualTo(saved.getId());
    }

    @Test
    void deleteCompetency() {
        Competency competency = competencyRepository.save(TestData.competency());

        competencyController.delete(competency.getId());

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