package com.geo.easypoint.common.mapper;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.area.structure.domain.AreaStructure;
import com.geo.easypoint.competency.domain.Competency;
import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.employee.entity.JobTitle;
import com.geo.easypoint.authentication.domain.user.EasyPointUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class EasyPointMapperTest extends AbstractAppTest {

    @Test
    void toEmployeeDtoTest() {
        Assertions.assertThat(EasyPointMapper.toEmployeeDto(TestData.employee()))
                .usingRecursiveComparison()
                .isEqualTo(TestData.employeeDto());
    }

    @Test
    void toEmployeeListDtoTest() {
        Assertions.assertThat(List.of(EasyPointMapper.toEmployeeDto(TestData.employee())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.employeeDto()));
    }

    @Test
    void toEmployeeTest() {
        Employee employee = EasyPointMapper.toEmployee(TestData.createEmployeeRequest(), List.of(TestData.adminStructure()));
        Assertions.assertThat(employee)
                .usingRecursiveComparison()
                .ignoringFields(TestData.baseEntityFields())
                .isEqualTo(TestData.employee());
        Assertions.assertThat(employee.getId())
                .isNull();
        Assertions.assertThat(employee.getCreated())
                .isNull();
        Assertions.assertThat(employee.getUpdated())
                .isNull();
    }

    @Test
    void toWorkShiftTypeDtoTest() {
    }

    @Test
    void testToWorkShiftTypeDtoTest() {
    }

    @Test
    void toWorkShiftTypeTest() {
    }

    @Test
    void toEasyPointUserTest() {
        EasyPointUser easyPointUser = EasyPointMapper.toEasyPointUser(
                TestData.USERNAME, TestData.employee(), TestData.PASSWORD
        );
        Assertions.assertThat(easyPointUser)
                .usingRecursiveComparison()
                .ignoringFields(TestData.baseEntityFields())
                .isEqualTo(TestData.easyPointUser());
        Assertions.assertThat(easyPointUser.getId())
                .isNull();
    }

    @Test
    void toAuthenticationResponseTest() {
        Assertions.assertThat(EasyPointMapper.toAuthenticationResponse(TestData.easyPointUser(), TestData.JWT_TOKEN))
                .usingRecursiveComparison()
                .isEqualTo(TestData.authenticationResponse());
    }


    @Test
    void toPointTest() {
        Assertions.assertThat(EasyPointMapper.toPoint(
                        TestData.pointCreateRequestDto(),
                        TestData.employee(),
                        TestData.pointType(),
                        TestData.pointState(),
                        TestData.areaStructure()
                ))
                .usingRecursiveComparison()
                .ignoringFields(TestData.baseEntityFields())
                .isEqualTo(TestData.point());
    }

    @Test
    void toPointTypeDtoTest() {
        Assertions.assertThat(EasyPointMapper.toPointTypeDto(TestData.pointType()))
                .usingRecursiveComparison()
                .isEqualTo(TestData.pointTypeDto());
    }

    @Test
    void toPointTypeCollectionDtoTest() {
        Assertions.assertThat(EasyPointMapper.toPointTypeDto(List.of(TestData.pointType())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.pointTypeDto()));
    }

    @Test
    void toPointStateDtoTest() {
        Assertions.assertThat(EasyPointMapper.toPointStateDto(List.of(TestData.pointState())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.pointStateDto()));
    }

    @Test
    void toTotalStationDtoTest() {
        Assertions.assertThat(EasyPointMapper.toTotalStationDto(List.of(TestData.totalStation())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.totalStationDto()));
    }

    @Test
    void toTotalStationTest() {
        Assertions.assertThat(EasyPointMapper.toTotalStation(TestData.totalStationCreateRequestDto()))
                .usingRecursiveComparison()
                .ignoringFields(TestData.baseEntityFields())
                .isEqualTo(TestData.totalStation());
    }

    @Test
    void toAreaStructureDtoTest() {
        Assertions.assertThat(EasyPointMapper.toAreaStructureDto(List.of(TestData.areaStructure())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.areaStructureDto()));
    }

    @Test
    void toAreaStructureTypeDtoTest() {
        Assertions.assertThat(EasyPointMapper.toAreaStructureTypeDto(List.of(TestData.areaStructureType())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.areaStructureTypeDto()));
    }

    @Test
    void toAreaStructureTypeTest() {
        Assertions.assertThat(EasyPointMapper.toAreaStructureType(TestData.areaStructureTypeCreateRequestDto()))
                .usingRecursiveComparison()
                .ignoringFields(TestData.baseEntityFields())
                .isEqualTo(TestData.areaStructureTypeDto());
    }

    @Test
    void toAreaDtoTest() {
        Assertions.assertThat(EasyPointMapper.toAreaDto(TestData.areaStructure()))
                .usingRecursiveComparison()
                .isEqualTo(TestData.areaDto());
    }

    @Test
    void toAreaCollectionDtoTest() {
        Assertions.assertThat(EasyPointMapper.toAreaDto(List.of(TestData.areaStructure())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.areaDto()));
    }

    @Test
    void testToAreaStructureTypeTest() {
        AreaStructure areaStructure = EasyPointMapper.toAreaStructure(
                TestData.areaStructureCreateRequestDto(), TestData.areaStructure(), TestData.areaStructureType()
        );
        Assertions.assertThat(areaStructure)
                .usingRecursiveComparison()
                .ignoringFields("created", "updated", "id", "parent")
                .isEqualTo(TestData.areaStructure());
        Assertions.assertThat(areaStructure.getParent())
                .usingRecursiveComparison()
                .ignoringFields(TestData.baseEntityFields())
                .isEqualTo(TestData.areaStructure());
    }

    @Test
    void testToPointDtoTest() {
        Assertions.assertThat(EasyPointMapper.toPointDto(
                        List.of(TestData.point())
                ))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.pointDto()));
    }

    @Test
    void toDownloadResponseTest() {
        Assertions.assertThat(EasyPointMapper.toDownloadResponse(new byte[0], TestData.NAME))
                .usingRecursiveComparison()
                .isEqualTo(TestData.downloadResponse());
    }

    @Test
    void toCsvPointDtoTest() {
        Assertions.assertThat(EasyPointMapper.toCsvPointDto(TestData.point()))
                .usingRecursiveComparison()
                .isEqualTo(TestData.csvPointDto());
    }

    @Test
    void toCsvPointCollectionDtoTest() {
        Assertions.assertThat(EasyPointMapper.toCsvPointDto(List.of(TestData.point())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.csvPointDto()));
    }


    @Test
    void toEasyPointCsvFileTest() {
        Assertions.assertThat(EasyPointMapper.toEasyPointCsvFile(List.of(TestData.csvColumn()), List.of(), TestData.NAME))
                .usingRecursiveComparison()
                .isEqualTo(TestData.csvPointFile());
    }

    @Test
    void toCompetencyDtoTest() {
        Assertions.assertThat(EasyPointMapper.toCompetencyDto(List.of(TestData.competency())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.competencyDto()));
    }

    @Test
    void toCompetencyTest() {
        Competency competency = EasyPointMapper.toCompetency(TestData.competencyCreateRequest());

        Assertions.assertThat(competency)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(TestData.competency());

        Assertions.assertThat(competency.getId())
                .isNull();
    }

    @Test
    void toJobTitleDtoTest() {
        Assertions.assertThat(EasyPointMapper.toJobTitleDto(List.of(TestData.jobTitle())))
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.jobtitleDto()));
    }

    @Test
    void toJobTitleTest() {
        JobTitle jobTitle = EasyPointMapper.toJobTitle(TestData.jobTitleCreateRequest());

        Assertions.assertThat(jobTitle)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(TestData.jobTitle());

        Assertions.assertThat(jobTitle.getId())
                .isNull();
    }
}