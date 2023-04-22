package com.geo.easypoint.employee.service;

import com.geo.easypoint.EasyPointAssertions;
import com.geo.easypoint.TestData;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.employee.dto.request.CompetencyPartialUpdateRequest;
import com.geo.easypoint.employee.entity.Competency;
import com.geo.easypoint.employee.repository.CompetencyRepository;
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
class CompetencyServiceTest {

    @Mock
    private CompetencyRepository competencyRepository;
    @InjectMocks
    private CompetencyService competencyService;

    @Test
    void createCompetency() {
        competencyService.createCompetency(TestData.competencyCreateRequest());
        EasyPointAssertions.assertThat(competencyRepository)
                .save(Competency.builder()
                        .name(TestData.NAME)
                        .description(TestData.DESCRIPTION)
                        .build());
    }

    @Test
    void updateCompetency() {
        String newName = "new name";
        Competency competency = TestData.competency();
        Mockito.when(competencyRepository.findById(TestData.ID))
                .thenReturn(Optional.of(competency));
        competencyService.updateCompetency(new CompetencyPartialUpdateRequest(JsonNullable.of(newName), JsonNullable.undefined()), TestData.ID);
        EasyPointAssertions.assertThat(competencyRepository)
                .save(Competency.builder()
                        .name(newName)
                        .description(competency.getDescription())
                        .id(competency.getId())
                        .build());
    }

    @Test
    void updateCompetencyFailOnNotFound() {
        Mockito.when(competencyRepository.findById(TestData.ID))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(
                () -> competencyService.updateCompetency(TestData.competencyPartialUpdateRequest(), TestData.ID)
        ).isInstanceOf(NotFoundException.class);
    }

    @Test
    void findAll() {
        Mockito.when(competencyRepository.findAll())
                .thenReturn(List.of(TestData.competency()));

        Assertions.assertThat(competencyService.findAll())
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.competencyDto()));
    }
}