package com.geo.easypoint.mapper;

import com.geo.easypoint.TestData;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EasyPointMapperTest {

    @Test
    public void toEmployeeDto() {
        Assertions.assertThat(TestData.employeeDto())
                .isEqualTo(EasyPointMapper.toEmployeeDto(TestData.employee()));
    }

    @Test
    public void toEmployeesDto() {
        Assertions.assertThat(List.of(TestData.employeeDto()))
                .isEqualTo(EasyPointMapper.toEmployeeDto(List.of(TestData.employee())));
    }

    @Test
    public void toPlummet() {
        Assertions.assertThat(TestData.plummet())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(EasyPointMapper.toPlummet(TestData.plummetCreateDto()));
    }

    @Test
    public void toPlummetDto() {
        Assertions.assertThat(List.of(TestData.plummetDto()))
                .usingRecursiveComparison()
                .isEqualTo(EasyPointMapper.toPlummetDto(List.of(TestData.plummet())));
    }
}