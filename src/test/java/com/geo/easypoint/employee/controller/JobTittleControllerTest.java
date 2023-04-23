package com.geo.easypoint.employee.controller;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.employee.dto.response.JobTitleDto;
import com.geo.easypoint.employee.entity.JobTitle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JobTittleControllerTest extends AbstractAppTest {
    @BeforeEach
    public void init() {
        jobTitleRepository.deleteAll();
    }

    @Test
    void createCompetency() {
        jobTittleController.createJobTitle(TestData.jobTitleCreateRequest());
        JobTitle jobTitle = jobTitleRepository.findAll().iterator().next();

        Assertions.assertThat(jobTitle)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(TestData.jobTitle());

        Assertions.assertThat(jobTitle.getId())
                .isNotNull();
    }

    @Test
    void updateCompetency() {
        JobTitle saved = jobTitleRepository.save(JobTitle.builder()
                .name("")
                .description("")
                .build());
        jobTittleController.updateJobTitle(TestData.jobTitlePartialUpdateRequest(), saved.getId());

        JobTitle updated = jobTitleRepository.findAll().iterator().next();

        Assertions.assertThat(updated)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(TestData.jobTitle());

        Assertions.assertThat(updated.getId())
                .isEqualTo(saved.getId());
    }

    @Test
    void deleteJobTittle() {
        JobTitle saved = jobTitleRepository.save(TestData.jobTitle());

        jobTittleController.deleteJobTitle(saved.getId());

        Assertions.assertThat(jobTitleRepository.findAll())
                .isEmpty();
    }

    @Test
    void findAll() {
        JobTitle saved = jobTitleRepository.save(TestData.jobTitle());
        JobTitleDto jobTitleDto = jobTittleController.findAll().iterator().next();

        Assertions.assertThat(jobTitleDto)
                .usingRecursiveComparison()
                .isEqualTo(saved);
    }
}