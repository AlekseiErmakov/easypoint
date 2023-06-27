package com.geo.easypoint.mapper;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geo.easypoint.TestData;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EasyPointMapperTest {

    @Test
    public void toEmployeeDto() {

        Assertions.assertThat(EasyPointMapper.toEmployeeDto(TestData.employee()))
                .isEqualTo(TestData.employeeDto());
    }

    @Test
    public void toEmployeesDto() {
        Assertions.assertThat(EasyPointMapper.toEmployeeDto(List.of(TestData.employee())))
                .isEqualTo(List.of(TestData.employeeDto()));
    }

    @Test
    public void toPlummet() {
        Assertions.assertThat(EasyPointMapper.toPlummet(TestData.plummetCreateDto()))
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(TestData.plummet());
    }

    @Test
    public void toPlummetDto() {
        Assertions.assertThat(EasyPointMapper.toPlummetDto(List.of(TestData.plummet())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.plummetDto()));
    }

    @Test
    public void toToolStateTest() {
        Assertions.assertThat(EasyPointMapper.toToolState(TestData.toolStateCreateDto()))
                .usingRecursiveComparison()
                .ignoringFields("created", "updated")
                .isEqualTo(TestData.toolState());
    }

    @Test
    public void toToolStateDtoTest() {
        Assertions.assertThat(EasyPointMapper.toToolStateDto(TestData.toolState()))
                .usingRecursiveComparison()
                .isEqualTo(TestData.toolStateDto());
    }
}