package com.geo.easypoint.common.mapper;

import com.geo.easypoint.organizationstructure.administrative.unit.domain.AdministrativeUnit;
import com.geo.easypoint.organizationstructure.administrative.unit.web.AdministrativeUnitCreateDto;
import com.geo.easypoint.organizationstructure.administrative.unit.web.AdministrativeUnitDto;
import com.geo.easypoint.organizationstructure.administrative.unit.web.AdministrativeUnitTreeDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.domain.AdministrativeUnitType;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeCreateDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeDto;
import com.geo.easypoint.organizationstructure.area.structure.domain.AreaStructure;
import com.geo.easypoint.organizationstructure.area.structure.web.AreaDto;
import com.geo.easypoint.organizationstructure.area.structure.web.AreaStructureCreateRequestDto;
import com.geo.easypoint.organizationstructure.area.structure.web.AreaStructureDto;
import com.geo.easypoint.organizationstructure.area.structuretype.domain.AreaStructureType;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeCreateDto;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeDto;
import com.geo.easypoint.authentication.domain.user.EasyPointUser;
import com.geo.easypoint.authentication.web.AuthenticationResponse;
import com.geo.easypoint.common.files.BeanToCsvMapper;
import com.geo.easypoint.common.files.CsvColumn;
import com.geo.easypoint.common.files.DownloadResponse;
import com.geo.easypoint.common.files.EasyPointFile;
import com.geo.easypoint.employees.competency.domain.Competency;
import com.geo.easypoint.employees.competency.web.CompetencyCreateDto;
import com.geo.easypoint.employees.competency.web.CompetencyDto;
import com.geo.easypoint.employees.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employees.employee.dto.response.EmployeeDto;
import com.geo.easypoint.employees.employee.dto.response.EmployeeTableDto;
import com.geo.easypoint.employees.employee.entity.Employee;
import com.geo.easypoint.employees.jobtitle.domain.JobTitle;
import com.geo.easypoint.employees.jobtitle.web.JobTitleCreateDto;
import com.geo.easypoint.employees.jobtitle.web.JobTitleDto;
import com.geo.easypoint.justification.point.domain.Point;
import com.geo.easypoint.justification.point.web.CsvPointDto;
import com.geo.easypoint.justification.point.web.PointCreateRequestDto;
import com.geo.easypoint.justification.point.web.PointDto;
import com.geo.easypoint.justification.point.web.PointUpdateRequest;
import com.geo.easypoint.justification.pointstate.domain.PointState;
import com.geo.easypoint.justification.pointstate.web.PointStateDto;
import com.geo.easypoint.justification.pointtype.domain.PointType;
import com.geo.easypoint.justification.pointtype.web.PointTypeDto;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import com.geo.easypoint.tool.plummet.web.PlummetCreateDto;
import com.geo.easypoint.tool.plummet.web.PlummetDto;
import com.geo.easypoint.tool.state.domain.ToolState;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateDto;
import com.geo.easypoint.tool.totalstation.domain.TotalStation;
import com.geo.easypoint.tool.totalstation.web.TotalStationCreateRequestDto;
import com.geo.easypoint.tool.totalstation.web.TotalStationDto;
import com.geo.easypoint.employees.workshifttype.domain.WorkShiftType;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeCreateRequest;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeDto;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EasyPointMapper {
    private static final ApplicationMapper APPLICATION_MAPPER = Mappers.getMapper(ApplicationMapper.class);

    public static EmployeeTableDto toEmployeeDto(Employee employee) {
        return APPLICATION_MAPPER.toEmployeeDto(employee);
    }

    public static List<EmployeeTableDto> toEmployeeDto(Collection<Employee> employees) {
        return APPLICATION_MAPPER.toEmployeeDto(employees);
    }

    public static Employee toEmployee(CreateEmployeeRequest createEmployeeRequest, List<AdministrativeUnit> administrativeUnits) {
        return APPLICATION_MAPPER.toEmployee(createEmployeeRequest, administrativeUnits);
    }

    public static WorkShiftTypeDto toWorkShiftTypeDto(WorkShiftType workShiftType) {
        return APPLICATION_MAPPER.toWorkShiftTypeDto(workShiftType);
    }

    public static List<WorkShiftTypeDto> toWorkShiftTypeDto(Collection<WorkShiftType> workShiftTypes) {
        return APPLICATION_MAPPER.toWorkShiftTypeDto(workShiftTypes);
    }

    public static WorkShiftType toWorkShiftType(WorkShiftTypeCreateRequest workShiftTypeCreateRequest) {
        return APPLICATION_MAPPER.toWorkShiftType(workShiftTypeCreateRequest);
    }


    public static EasyPointUser toEasyPointUser(String username, Employee employee, String password) {
        return EasyPointUser.builder()
                .username(username)
                .password(password)
                .employee(employee)
                .enabled(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .build();
    }

    public static AuthenticationResponse toAuthenticationResponse(EasyPointUser user, String jwtToken) {
        return APPLICATION_MAPPER.toAuthenticationResponse(user, jwtToken);
    }

    public static PointDto toPointDto(Point point) {
        return APPLICATION_MAPPER.toPointWithAreasDto(point);
    }

    public static Point toPoint(PointCreateRequestDto request, Employee employee, PointType pointType, PointState pointState, AreaStructure area) {
        return APPLICATION_MAPPER.toPoint(request, employee, pointType, pointState, area);
    }

    public static PointTypeDto toPointTypeDto(PointType pointType) {
        return APPLICATION_MAPPER.toPointTypeDto(pointType);
    }

    public static List<PointTypeDto> toPointTypeDto(Collection<PointType> pointTypes) {
        return APPLICATION_MAPPER.toPointTypeDto(pointTypes);
    }

    public static List<PointStateDto> toPointStateDto(Collection<PointState> pointStates) {
        return APPLICATION_MAPPER.toPointStateDto(pointStates);
    }

    public static List<TotalStationDto> toTotalStationDto(Collection<TotalStation> totalStations) {
        return APPLICATION_MAPPER.toTotalStationDto(totalStations);
    }

    public static TotalStationDto toTotalStationDto(TotalStation totalStation) {
        return APPLICATION_MAPPER.toTotalStationDto(totalStation);
    }


    public static TotalStation toTotalStation(TotalStationCreateRequestDto createRequestDto) {
        return APPLICATION_MAPPER.toTotalStation(createRequestDto);
    }

    public static List<AreaStructureDto> toAreaStructureDto(List<AreaStructure> areaStructures) {
        return APPLICATION_MAPPER.toAreaStructureDto(areaStructures);
    }

    public static List<AreaStructureTypeDto> toAreaStructureTypeDto(List<AreaStructureType> all) {
        return APPLICATION_MAPPER.toAreaStructureTypeDto(all);

    }

    public static AreaStructureType toAreaStructureType(AreaStructureTypeCreateDto createRequestDto) {
        return APPLICATION_MAPPER.toAreaStructureType(createRequestDto);
    }

    public static AreaStructure toAreaStructure(AreaStructureCreateRequestDto request, AreaStructureType areaStructureType) {
        return APPLICATION_MAPPER.toAreaStructure(request, areaStructureType);
    }

    public static List<AreaDto> toAreaDto(List<AreaStructure> areas) {
        return APPLICATION_MAPPER.toAreaDto(areas);
    }

    public static AreaDto toAreaDto(AreaStructure area) {
        return APPLICATION_MAPPER.toAreaDto(area);
    }

    public static AreaStructure toAreaStructure(AreaStructureCreateRequestDto createRequestDto, AreaStructure parent, AreaStructureType areaStructureType) {
        return APPLICATION_MAPPER.toAreaStructure(createRequestDto, parent, areaStructureType);
    }

    public static List<PointDto> toPointDto(List<Point> points) {
        return points.stream()
                .map(APPLICATION_MAPPER::toPointWithAreasDto)
                .collect(Collectors.toList());
    }

    public static DownloadResponse toDownloadResponse(byte[] file, String fileName) {
        return APPLICATION_MAPPER.toDownloadResponse(file, fileName);
    }

    public static CsvPointDto toCsvPointDto(Point point) {
        return APPLICATION_MAPPER.toCsvPointDto(point);
    }

    public static List<CsvPointDto> toCsvPointDto(Collection<Point> points) {
        return APPLICATION_MAPPER.toCsvPointDto(points);
    }

    public static <T> EasyPointFile toEasyPointCsvFile(List<CsvColumn> columns, List<T> data, String fileName) {
        return new EasyPointFile(fileName, BeanToCsvMapper.toCsvFile(columns, data));
    }

    public static <T> List<T> fromFileToElements(Collection<CsvColumn> columns, MultipartFile file, Class<T> clazz) {
        return BeanToCsvMapper.fromCsvFile(columns, file, clazz);
    }

    public static List<Point> toPoint(List<CsvPointDto> csvPoints) {
        return APPLICATION_MAPPER.toPoint(csvPoints);
    }

    public static List<Point> toPoint(List<CsvPointDto> csvPoints, PointState pointState, Employee employee) {
        return csvPoints.stream().map(csvPoint -> APPLICATION_MAPPER.toPoint(csvPoint, pointState, employee))
                .collect(Collectors.toList());
    }

    public static void updatePoint(Point point, PointUpdateRequest request, PointType pointType, AreaStructure areaStructure, Employee employee) {
        APPLICATION_MAPPER.updatePoint(point, request, pointType, areaStructure, employee);
    }

    public static List<AdministrativeUnitTypeDto> toAdministrativeUnitTypeDto(List<AdministrativeUnitType> administrativeUnitTypes) {
        return APPLICATION_MAPPER.toAdministrativeUnitTypeDto(administrativeUnitTypes);
    }

    public static AdministrativeUnitType toAdministrativeUnitType(AdministrativeUnitTypeCreateDto request) {
        return APPLICATION_MAPPER.toAdministrativeUnitType(request);
    }

    public static List<AdministrativeUnitTreeDto> toAdministrativeUnitTreeDto(List<AdministrativeUnit> administrativeUnits) {
        return APPLICATION_MAPPER.toAdministrativeUnitTreeDto(administrativeUnits);
    }

    public static AdministrativeUnit toAdministrativeUnit(AdministrativeUnitCreateDto request, AdministrativeUnitType administrativeUnitType) {
        return APPLICATION_MAPPER.toAdministrativeUnit(request, administrativeUnitType);
    }

    public static <T> AdministrativeUnit toAdministrativeUnit(AdministrativeUnitCreateDto request, AdministrativeUnit parent, AdministrativeUnitType administrativeUnitType) {
        return APPLICATION_MAPPER.toAdministrativeUnit(request, parent, administrativeUnitType);
    }

    public static List<AdministrativeUnitDto> toAdministrativeUnitDto(List<AdministrativeUnit> structures) {
        return APPLICATION_MAPPER.toAdministrativeUnitDto(structures);
    }

    public static AdministrativeUnitDto toAdministrativeUnitDto(AdministrativeUnit administrativeUnit) {
        return APPLICATION_MAPPER.toAdministrativeUnitDto(administrativeUnit);
    }

    public static List<EmployeeTableDto> toEmployeeDto(List<Employee> employees) {
        return APPLICATION_MAPPER.toEmployeeDto(employees);
    }

    public static List<CompetencyDto> toCompetencyDto(Collection<Competency> competencies) {
        return APPLICATION_MAPPER.toCompetencyDto(competencies);
    }

    public static Competency toCompetency(CompetencyCreateDto request) {
        return APPLICATION_MAPPER.toCompetency(request);
    }

    public static List<JobTitleDto> toJobTitleDto(Collection<JobTitle> jobTitles) {
        return APPLICATION_MAPPER.toJobTitleDto(jobTitles);
    }

    public static JobTitle toJobTitle(JobTitleCreateDto request) {
        return APPLICATION_MAPPER.toJobTitle(request);
    }

    public static EmployeeDto toEmployeeInfoDto(Employee employee) {
        return APPLICATION_MAPPER.toEmployeeInfoDto(employee);
    }

    public static Plummet toPlummet(PlummetCreateDto plummetCreateDto) {
        return APPLICATION_MAPPER.toPlummet(plummetCreateDto);
    }

    public static List<PlummetDto> toPlummetDto(List<Plummet> plummets) {
        return APPLICATION_MAPPER.toPlummetDto(plummets);
    }

    public static List<ToolStateDto> toToolStateDto(List<ToolState> states) {
        return APPLICATION_MAPPER.toToolStateDto(states);
    }

    public static ToolStateDto toToolStateDto(ToolState state) {
        return APPLICATION_MAPPER.toToolStateDto(state);
    }

    public static ToolState toToolState(ToolStateCreateDto toolStateDto) {
        return APPLICATION_MAPPER.toToolState(toolStateDto);
    }
}
