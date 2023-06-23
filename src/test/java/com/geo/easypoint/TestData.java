package com.geo.easypoint;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.geo.easypoint.administrative.unit.domain.AdministrativeUnit;
import com.geo.easypoint.administrative.unit.web.AdministrativeUnitCreateDto;
import com.geo.easypoint.administrative.unit.web.AdministrativeUnitDto;
import com.geo.easypoint.administrative.unit.web.AdministrativeUnitTreeDto;
import com.geo.easypoint.administrative.unittype.domain.AdministrativeUnitType;
import com.geo.easypoint.administrative.unittype.web.AdministrativeUnitTypeDto;
import com.geo.easypoint.area.structure.domain.AreaStructure;
import com.geo.easypoint.area.structure.web.AreaDto;
import com.geo.easypoint.area.structure.web.AreaStructureCreateRequestDto;
import com.geo.easypoint.area.structure.web.AreaStructureDto;
import com.geo.easypoint.area.structuretype.domain.AreaStructureType;
import com.geo.easypoint.area.structuretype.web.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.area.structuretype.web.AreaStructureTypeDto;
import com.geo.easypoint.authentication.domain.user.EasyPointUser;
import com.geo.easypoint.authentication.web.AuthenticationResponse;
import com.geo.easypoint.common.files.CsvColumn;
import com.geo.easypoint.common.files.DownloadResponse;
import com.geo.easypoint.common.files.EasyPointFile;
import com.geo.easypoint.competency.domain.Competency;
import com.geo.easypoint.competency.web.CompetencyCreateRequest;
import com.geo.easypoint.competency.web.CompetencyPartialUpdateRequest;
import com.geo.easypoint.employee.dto.CompetencyDto;
import com.geo.easypoint.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employee.dto.response.EmployeeTableDto;
import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.employee.entity.JobTitle;
import com.geo.easypoint.jobtitle.web.JobTitleCreateRequest;
import com.geo.easypoint.jobtitle.web.JobTitleDto;
import com.geo.easypoint.jobtitle.web.JobTitlePartialUpdateRequest;
import com.geo.easypoint.point.domain.Point;
import com.geo.easypoint.point.web.CsvPointDto;
import com.geo.easypoint.point.web.PointCreateRequestDto;
import com.geo.easypoint.point.web.PointDto;
import com.geo.easypoint.pointstate.domain.PointState;
import com.geo.easypoint.pointstate.domain.PointType;
import com.geo.easypoint.pointstate.domain.PointTypes;
import com.geo.easypoint.pointstate.web.PointStateDto;
import com.geo.easypoint.pointstate.web.PointStates;
import com.geo.easypoint.pointtype.web.PointTypeDto;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import com.geo.easypoint.tool.plummet.web.PlummetCreateDto;
import com.geo.easypoint.tool.plummet.web.PlummetDto;
import com.geo.easypoint.tool.totalstation.domain.TotalStation;
import com.geo.easypoint.tool.totalstation.web.TotalStationCreateRequestDto;
import com.geo.easypoint.tool.totalstation.web.TotalStationDto;
import com.geo.easypoint.workshifttype.domain.WorkShiftType;
import org.openapitools.jackson.nullable.JsonNullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public final class TestData {

    public static final Long ID = 1L;
    public static final BigDecimal X = BigDecimal.valueOf(1000.000);
    public static final BigDecimal Y = BigDecimal.valueOf(2000.000);
    public static final BigDecimal H = BigDecimal.valueOf(30.000);
    public static final String DESCRIPTION = "description";
    public static final String NAME = "point state name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String JWT_TOKEN = "jwt token";
    public static final String SHORT_NAME = "point state name";
    public static final String FIRSTNAME = "firstname";
    public static final String SURNAME = "surname";
    public static final String MIDDLE_NAME = "middle name";
    public static final String MODEL = "model";
    public static final String FIRM = "firm";
    public static final String SERIAL_NUMBER = "serial number";
    public static final String AREA_STRUCTURE_TYPE = "area structure type";
    public static final LocalDateTime CREATED = LocalDateTime.now();
    public static final LocalDateTime UPDATED = CREATED.plusDays(1);

    private TestData() {
    }


    public static WorkShiftType workShiftType() {
        return WorkShiftType.builder()
                .id(ID)
                .name(NAME)
                .created(CREATED)
                .updated(UPDATED)
                .shortname(SHORT_NAME)
                .build();
    }

    public static Employee employee() {
        return Employee.builder()
                .id(ID)
                .firstname(FIRSTNAME)
                .lastname(MIDDLE_NAME)
                .surname(SURNAME)
                .created(CREATED)
                .updated(UPDATED)
                .administrativeUnits(Set.of(adminStructure()))
                .build();
    }

    public static AdministrativeUnitCreateDto adminStructureCreateRequest() {
        return new AdministrativeUnitCreateDto(NAME, ID, DESCRIPTION, ID);
    }

    public static AdministrativeUnitTypeDto adminStructureTypeDto() {
        return new AdministrativeUnitTypeDto(ID, NAME, DESCRIPTION);
    }

    public static AdministrativeUnitType adminStructureType() {
        return AdministrativeUnitType.builder()
                .id(ID)
                .name(NAME)
                .description(DESCRIPTION)
                .created(CREATED)
                .updated(UPDATED)
                .build();
    }

    public static AdministrativeUnitTreeDto adminStructureDto() {
        return new AdministrativeUnitTreeDto(ID, NAME, adminStructureTypeDto(), DESCRIPTION, List.of());
    }

    public static AdministrativeUnitDto adminDto() {
        return new AdministrativeUnitDto(ID, NAME, DESCRIPTION);
    }

    public static AdministrativeUnit adminStructure() {
        return AdministrativeUnit.builder()
                .id(ID)
                .parent(null)
                .name(NAME)
                .administrativeUnitType(adminStructureType())
                .description(DESCRIPTION)
                .created(CREATED)
                .updated(UPDATED)
                .build();
    }

    public static EmployeeTableDto employeeDto() {
        return new EmployeeTableDto(ID, FIRSTNAME, SURNAME, MIDDLE_NAME, CREATED, UPDATED, List.of(adminDto()));
    }

    public static CreateEmployeeRequest createEmployeeRequest() {
        return new CreateEmployeeRequest(FIRSTNAME, SURNAME, MIDDLE_NAME, List.of());
    }

    public static PointCreateRequestDto pointCreateRequestDto() {
        return new PointCreateRequestDto(NAME, X, Y, H, ID, ID);
    }

    public static PointState pointState() {
        return PointState.builder()
                .id(ID)
                .code(PointStates.CREATED)
                .description(DESCRIPTION)
                .name(NAME)
                .build();
    }

    public static PointStateDto pointStateDto() {
        return new PointStateDto(ID, PointStates.CREATED, NAME, DESCRIPTION);
    }

    public static PointType pointType() {
        return PointType.builder()
                .id(ID)
                .code(PointTypes.FIXED_POINT)
                .description(DESCRIPTION)
                .name(NAME)
                .build();
    }

    public static PointTypeDto pointTypeDto() {
        return new PointTypeDto(ID, PointTypes.FIXED_POINT, NAME, DESCRIPTION);
    }


    public static AreaStructureType areaStructureType() {
        return AreaStructureType.builder()
                .id(ID)
                .description(DESCRIPTION)
                .name(NAME)
                .build();
    }

    public static AreaStructureTypeDto areaStructureTypeDto() {
        return new AreaStructureTypeDto(ID, NAME, DESCRIPTION);
    }

    public static AreaStructureTypeCreateRequestDto areaStructureTypeCreateRequestDto() {
        return new AreaStructureTypeCreateRequestDto(NAME, DESCRIPTION);
    }

    public static AreaStructure areaStructure() {
        return AreaStructure.builder()
                .areaStructureType(areaStructureType())
                .name(NAME)
                .description(DESCRIPTION)
                .id(ID)
                .created(CREATED)
                .updated(UPDATED)
                .children(Set.of())
                .build();
    }

    public static AreaStructureDto areaStructureDto() {
        return new AreaStructureDto(ID, NAME, areaStructureTypeDto(), DESCRIPTION, List.of());
    }

    public static AreaStructureCreateRequestDto areaStructureCreateRequestDto() {
        return new AreaStructureCreateRequestDto(NAME, ID, DESCRIPTION, ID);
    }

    public static AreaDto areaDto() {
        return new AreaDto(ID, NAME, DESCRIPTION);
    }

    public static TotalStation totalStation() {
        return TotalStation.builder()
                .id(ID)
                .firm(FIRM)
                .model(MODEL)
                .serialNumber(SERIAL_NUMBER)
                .created(CREATED)
                .updated(UPDATED)
                .build();
    }

    public static TotalStationDto totalStationDto() {
        return new TotalStationDto(ID, FIRM, MODEL, SERIAL_NUMBER);
    }

    public static TotalStationCreateRequestDto totalStationCreateRequestDto() {
        return new TotalStationCreateRequestDto(FIRM, MODEL, SERIAL_NUMBER);
    }

    public static Point point() {
        return Point.builder()
                .pointState(pointState())
                .areaStructure(areaStructure())
                .pointType(pointType())
                .creator(employee())
                .x(X)
                .y(Y)
                .h(H)
                .name(NAME)
                .id(ID)
                .updated(UPDATED)
                .created(CREATED)
                .build();
    }

    public static PointDto pointDto() {
        return new PointDto(ID, NAME, X, Y, H, CREATED.toLocalDate(), ID, UPDATED.toLocalDate(), employeeDto(), pointTypeDto(), pointStateDto(), List.of(areaDto()));
    }

    public static EasyPointUser easyPointUser() {
        return EasyPointUser.builder()
                .id(ID)
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .employee(employee())
                .enabled(true)
                .username(USERNAME)
                .password(PASSWORD)
                .build();
    }

    public static Competency competency() {
        return Competency.builder()
                .id(ID)
                .description(DESCRIPTION)
                .name(NAME)
                .build();
    }

    public static CompetencyDto competencyDto() {
        return new CompetencyDto(ID, NAME, DESCRIPTION);
    }

    public static CompetencyCreateRequest competencyCreateRequest() {
        return new CompetencyCreateRequest(NAME, DESCRIPTION);
    }

    public static CompetencyPartialUpdateRequest competencyPartialUpdateRequest() {
        return new CompetencyPartialUpdateRequest(JsonNullable.of(NAME), JsonNullable.of(DESCRIPTION));
    }


    public static JobTitle jobTitle() {
        return JobTitle.builder()
                .id(ID)
                .description(DESCRIPTION)
                .name(NAME)
                .build();
    }

    public static JobTitleDto jobtitleDto() {
        return new JobTitleDto(ID, NAME, DESCRIPTION);
    }

    public static JobTitleCreateRequest jobTitleCreateRequest() {
        return new JobTitleCreateRequest(NAME, DESCRIPTION);
    }

    public static JobTitlePartialUpdateRequest jobTitlePartialUpdateRequest() {
        return new JobTitlePartialUpdateRequest(JsonNullable.of(NAME), JsonNullable.of(DESCRIPTION));
    }

    public static AuthenticationResponse authenticationResponse() {
        return new AuthenticationResponse(TestData.USERNAME, TestData.JWT_TOKEN, TestData.employeeDto());
    }

    public static String[] baseEntityFields() {
        return new String[]{"id", "created", "updated"};
    }

    public static CsvPointDto csvPointDto() {
        return new CsvPointDto(NAME, NAME, X, Y, H);
    }

    public static DownloadResponse downloadResponse() {
        return new DownloadResponse(NAME, new byte[0]);
    }

    public static CsvColumn csvColumn() {
        return new CsvColumn(NAME, CsvSchema.ColumnType.STRING);
    }

    public static EasyPointFile csvPointFile() {
        return new EasyPointFile(NAME, new byte[0]);
    }

    public static Plummet plummet() {
        return Plummet.builder()
                .id(ID)
                .name(NAME)
                .build();
    }

    public static PlummetCreateDto plummetCreateDto() {
        return new PlummetCreateDto(NAME);
    }

    public static PlummetDto plummetDto() {
        return PlummetDto.builder()
                .id(ID)
                .name(NAME)
                .build();
    }
}
