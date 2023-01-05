package com.geo.easypoint.iml.mapper;

import com.geo.easypoint.TestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}