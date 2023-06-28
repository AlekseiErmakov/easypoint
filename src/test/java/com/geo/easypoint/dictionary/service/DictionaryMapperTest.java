package com.geo.easypoint.dictionary.service;

import com.geo.easypoint.TestData;
import com.geo.easypoint.common.dictionary.service.DictionaryMapper;
import com.geo.easypoint.employees.jobtitle.domain.JobTitle;
import com.geo.easypoint.employees.jobtitle.service.JobTitleMapper;
import com.geo.easypoint.employees.jobtitle.web.JobTitleCreateDto;
import com.geo.easypoint.employees.jobtitle.web.JobTitleDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class DictionaryMapperTest {
    private final DictionaryMapper<JobTitle, JobTitleDto, JobTitleCreateDto> mapper = Mappers.getMapper(JobTitleMapper.class);

    @Test
    void toDtoTest() {
        Assertions.assertThat(mapper.toDto(TestData.jobTitle()))
                .usingRecursiveComparison()
                .isEqualTo(TestData.jobtitleDto());
    }

    @Test
    void toEntityTest() {
        Assertions.assertThat(mapper.toEntity(TestData.jobTitleCreateRequest()))
                .usingRecursiveComparison()
                .ignoringFields("id", "created", "updated")
                .isEqualTo(TestData.jobTitle());
    }
}