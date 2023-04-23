package com.geo.easypoint.employee.service;

import com.geo.easypoint.EasyPointAssertions;
import com.geo.easypoint.TestData;
import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.employee.dto.request.JobTitlePartialUpdateRequest;
import com.geo.easypoint.employee.entity.JobTitle;
import com.geo.easypoint.employee.repository.EmployeeRepository;
import com.geo.easypoint.employee.repository.JobTitleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class JobTitleServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private JobTitleRepository jobTitleRepository;
    @InjectMocks
    private JobTitleService jobTitleService;

    @Test
    void createJobTitle() {
        jobTitleService.createJobTitle(TestData.jobTitleCreateRequest());
        EasyPointAssertions.assertThat(jobTitleRepository)
                .save(JobTitle.builder()
                        .name(TestData.NAME)
                        .description(TestData.DESCRIPTION)
                        .build());
    }

    @Test
    void updateJobTitle() {
        String newName = "new name";
        JobTitle jobTitle = TestData.jobTitle();
        Mockito.when(jobTitleRepository.findById(TestData.ID))
                .thenReturn(Optional.of(jobTitle));
        jobTitleService.updateJobTitle(new JobTitlePartialUpdateRequest(JsonNullable.of(newName), JsonNullable.undefined()), TestData.ID);
        EasyPointAssertions.assertThat(jobTitleRepository)
                .save(JobTitle.builder()
                        .name(newName)
                        .description(jobTitle.getDescription())
                        .id(jobTitle.getId())
                        .build());
    }

    @Test
    void updateJobTitleFailOnNotFound() {
        Mockito.when(jobTitleRepository.findById(TestData.ID))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(
                () -> jobTitleService.updateJobTitle(TestData.jobTitlePartialUpdateRequest(), TestData.ID)
        ).isInstanceOf(NotFoundException.class);
    }

    @Test
    void deleteJobTitle() {
        JobTitle jobTitle = TestData.jobTitle();
        Mockito.when(jobTitleRepository.findById(TestData.ID))
                .thenReturn(Optional.of(jobTitle));

        Mockito.when(employeeRepository.existsByJobTitle_Id(TestData.ID))
                .thenReturn(false);

        jobTitleService.deleteJobTitle(jobTitle.getId());

        EasyPointAssertions.assertThat(jobTitleRepository)
                .delete(jobTitle);
    }

    @Test
    void neverDeleteJobTitleIfPresentInEmployee() {
        JobTitle jobTitle = TestData.jobTitle();
        Mockito.when(jobTitleRepository.findById(TestData.ID))
                .thenReturn(Optional.of(jobTitle));

        Mockito.when(employeeRepository.existsByJobTitle_Id(TestData.ID))
                .thenReturn(true);

        Assertions.assertThatThrownBy(() ->jobTitleService.deleteJobTitle(jobTitle.getId()))
                .isInstanceOf(EasyPointLogicException.class);

        EasyPointAssertions.assertThat(jobTitleRepository)
                .neverDelete(jobTitle);
    }

    @Test
    void findAll() {
        Mockito.when(jobTitleRepository.findAll())
                .thenReturn(List.of(TestData.jobTitle()));

        Assertions.assertThat(jobTitleService.findAll())
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.jobtitleDto()));
    }
}