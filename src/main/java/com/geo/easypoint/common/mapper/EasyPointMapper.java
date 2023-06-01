package com.geo.easypoint.common.mapper;

import com.geo.easypoint.administrative.dto.AdministrativeUnitDto;
import com.geo.easypoint.administrative.dto.AdministrativeUnitTreeDto;
import com.geo.easypoint.administrative.dto.AdministrativeUnitTypeDto;
import com.geo.easypoint.administrative.dto.request.AdministrativeUnitCreateRequest;
import com.geo.easypoint.administrative.dto.request.AdministrativeUnitTypeCreateRequest;
import com.geo.easypoint.administrative.entity.AdministrativeUnit;
import com.geo.easypoint.administrative.entity.AdministrativeUnitType;
import com.geo.easypoint.area.dto.AreaDto;
import com.geo.easypoint.area.dto.AreaStructureDto;
import com.geo.easypoint.area.dto.AreaStructureTypeDto;
import com.geo.easypoint.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.area.dto.request.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.area.entity.AreaStructure;
import com.geo.easypoint.area.entity.AreaStructureType;
import com.geo.easypoint.common.DownloadResponse;
import com.geo.easypoint.employee.dto.CompetencyDto;
import com.geo.easypoint.employee.dto.request.CompetencyCreateRequest;
import com.geo.easypoint.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employee.dto.request.JobTitleCreateRequest;
import com.geo.easypoint.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.employee.dto.response.EmployeeDto;
import com.geo.easypoint.employee.dto.response.EmployeeTableDto;
import com.geo.easypoint.employee.dto.response.JobTitleDto;
import com.geo.easypoint.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.employee.entity.Competency;
import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.employee.entity.JobTitle;
import com.geo.easypoint.employee.entity.WorkShiftType;
import com.geo.easypoint.files.BeanToCsvMapper;
import com.geo.easypoint.files.CsvColumn;
import com.geo.easypoint.files.EasyPointFile;
import com.geo.easypoint.point.dto.CsvPointDto;
import com.geo.easypoint.point.dto.PointDto;
import com.geo.easypoint.point.dto.PointStateDto;
import com.geo.easypoint.point.dto.PointTypeDto;
import com.geo.easypoint.point.dto.request.PointCreateRequestDto;
import com.geo.easypoint.point.dto.request.PointUpdateRequest;
import com.geo.easypoint.point.entity.Point;
import com.geo.easypoint.point.entity.PointState;
import com.geo.easypoint.point.entity.PointType;
import com.geo.easypoint.tool.total.station.dto.TotalStationDto;
import com.geo.easypoint.tool.total.station.dto.request.TotalStationCreateRequestDto;
import com.geo.easypoint.tool.total.station.entity.TotalStation;
import com.geo.easypoint.users.dto.response.AuthenticationResponse;
import com.geo.easypoint.users.entity.EasyPointUser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public static TotalStation toTotalStation(TotalStationCreateRequestDto createRequestDto) {
        return APPLICATION_MAPPER.toTotalStation(createRequestDto);
    }

    public static List<AreaStructureDto> toAreaStructureDto(List<AreaStructure> areaStructures) {
        return APPLICATION_MAPPER.toAreaStructureDto(areaStructures);
    }

    public static List<AreaStructureTypeDto> toAreaStructureTypeDto(List<AreaStructureType> all) {
        return APPLICATION_MAPPER.toAreaStructureTypeDto(all);

    }

    public static AreaStructureType toAreaStructureType(AreaStructureTypeCreateRequestDto createRequestDto) {
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

    public static AdministrativeUnitType toAdministrativeUnitType(AdministrativeUnitTypeCreateRequest request) {
        return APPLICATION_MAPPER.toAdministrativeUnitType(request);
    }

    public static List<AdministrativeUnitTreeDto> toAdministrativeUnitTreeDto(List<AdministrativeUnit> administrativeUnits) {
        return APPLICATION_MAPPER.toAdministrativeUnitTreeDto(administrativeUnits);
    }

    public static AdministrativeUnit toAdministrativeUnit(AdministrativeUnitCreateRequest request, AdministrativeUnitType administrativeUnitType) {
        return APPLICATION_MAPPER.toAdministrativeUnit(request, administrativeUnitType);
    }

    public static <T> AdministrativeUnit toAdministrativeUnit(AdministrativeUnitCreateRequest request, AdministrativeUnit parent, AdministrativeUnitType administrativeUnitType) {
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

    public static Competency toCompetency(CompetencyCreateRequest request) {
        return APPLICATION_MAPPER.toCompetency(request);
    }

    public static List<JobTitleDto> toJobTitleDto(Collection<JobTitle> jobTitles) {
        return APPLICATION_MAPPER.toJobTitleDto(jobTitles);
    }

    public static JobTitle toJobTitle(JobTitleCreateRequest request) {
        return APPLICATION_MAPPER.toJobTitle(request);
    }

    public static EmployeeDto toEmployeeInfoDto(Employee employee) {
        return APPLICATION_MAPPER.toEmployeeInfoDto(employee);
    }
}
