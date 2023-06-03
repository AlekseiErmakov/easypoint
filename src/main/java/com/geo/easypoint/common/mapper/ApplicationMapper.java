package com.geo.easypoint.common.mapper;

import com.geo.easypoint.administrative.unit.web.AdministrativeUnitCreateDto;
import com.geo.easypoint.administrative.unit.web.AdministrativeUnitDto;
import com.geo.easypoint.administrative.unit.web.AdministrativeUnitTreeDto;
import com.geo.easypoint.administrative.unittype.web.AdministrativeUnitTypeDto;
import com.geo.easypoint.administrative.unittype.web.AdministrativeUnitTypeCreateRequest;
import com.geo.easypoint.administrative.unit.domain.AdministrativeUnit;
import com.geo.easypoint.administrative.unittype.domain.AdministrativeUnitType;
import com.geo.easypoint.area.structure.web.AreaDto;
import com.geo.easypoint.area.structure.web.AreaStructureDto;
import com.geo.easypoint.area.structuretype.web.AreaStructureTypeDto;
import com.geo.easypoint.area.structure.web.AreaStructureCreateRequestDto;
import com.geo.easypoint.area.structuretype.web.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.area.structure.domain.AreaStructure;
import com.geo.easypoint.area.structuretype.domain.AreaStructureType;
import com.geo.easypoint.common.files.DownloadResponse;
import com.geo.easypoint.employee.dto.CompetencyDto;
import com.geo.easypoint.competency.web.CompetencyCreateRequest;
import com.geo.easypoint.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.jobtitle.web.JobTitleCreateRequest;
import com.geo.easypoint.workshifttype.web.WorkShiftTypeCreateRequest;
import com.geo.easypoint.employee.dto.response.EmployeeDto;
import com.geo.easypoint.employee.dto.response.EmployeeTableDto;
import com.geo.easypoint.jobtitle.web.JobTitleDto;
import com.geo.easypoint.workshifttype.web.WorkShiftTypeDto;
import com.geo.easypoint.competency.domain.Competency;
import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.employee.entity.JobTitle;
import com.geo.easypoint.workshifttype.domain.WorkShiftType;
import com.geo.easypoint.point.web.CsvPointDto;
import com.geo.easypoint.point.web.PointDto;
import com.geo.easypoint.pointstate.web.PointStateDto;
import com.geo.easypoint.pointtype.web.PointTypeDto;
import com.geo.easypoint.point.web.PointCreateRequestDto;
import com.geo.easypoint.point.web.PointUpdateRequest;
import com.geo.easypoint.point.domain.Point;
import com.geo.easypoint.pointstate.domain.PointState;
import com.geo.easypoint.pointstate.domain.PointType;
import com.geo.easypoint.tool.totalstation.web.TotalStationDto;
import com.geo.easypoint.tool.totalstation.web.TotalStationCreateRequestDto;
import com.geo.easypoint.tool.totalstation.domain.TotalStation;
import com.geo.easypoint.authentication.web.AuthenticationResponse;
import com.geo.easypoint.authentication.domain.user.EasyPointUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ApplicationMapper {

    @Mapping(target = "administrativeUnits", source = "allAdministrativeUnits")
    EmployeeTableDto toEmployeeDto(Employee employee);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "administrativeUnits", source = "administrativeUnits")
    Employee toEmployee(CreateEmployeeRequest createEmployeeRequest, List<AdministrativeUnit> administrativeUnits);

    List<EmployeeTableDto> toEmployeeDto(Collection<Employee> employees);

    WorkShiftTypeDto toWorkShiftTypeDto(WorkShiftType workShiftType);

    List<WorkShiftTypeDto> toWorkShiftTypeDto(Collection<WorkShiftType> workShiftTypes);

    WorkShiftType toWorkShiftType(WorkShiftTypeCreateRequest workShiftTypeCreateRequest);

    @Mapping(target = "token", source = "jwtToken")
    AuthenticationResponse toAuthenticationResponse(EasyPointUser user, String jwtToken);


    @Mapping(target = "creator", source = "employee")
    @Mapping(target = "pointType", source = "pointType")
    @Mapping(target = "pointState", source = "pointState")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "areaStructure", source = "area")
    Point toPoint(PointCreateRequestDto request, Employee employee, PointType pointType, PointState pointState, AreaStructure area);

    PointTypeDto toPointTypeDto(PointType pointType);

    List<PointTypeDto> toPointTypeDto(Collection<PointType> pointTypes);

    PointStateDto toPointStateDto(PointState pointState);

    List<PointStateDto> toPointStateDto(Collection<PointState> pointStates);

    TotalStationDto toTotalStationDto(TotalStation totalStation);

    List<TotalStationDto> toTotalStationDto(Collection<TotalStation> totalStations);

    TotalStation toTotalStation(TotalStationCreateRequestDto request);

    List<AreaStructureDto> toAreaStructureDto(Collection<AreaStructure> areaStructures);

    AreaStructureDto toAreaStructureDto(AreaStructure areaStructure);

    AreaStructureDto toAreaStructureTypeDto(AreaStructureType areaStructureType);

    List<AreaStructureTypeDto> toAreaStructureTypeDto(List<AreaStructureType> areaStructureTypes);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "name", source = "createRequestDto.name")
    @Mapping(target = "description", source = "createRequestDto.description")
    @Mapping(target = "areaStructureType", source = "areaStructureType")
    AreaStructure toAreaStructure(AreaStructureCreateRequestDto createRequestDto, AreaStructureType areaStructureType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    AreaStructureType toAreaStructureType(AreaStructureTypeCreateRequestDto createRequestDto);

    AreaDto toAreaDto(AreaStructure areaStructure);

    List<AreaDto> toAreaDto(List<AreaStructure> areas);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "name", source = "createRequestDto.name")
    @Mapping(target = "description", source = "createRequestDto.description")
    @Mapping(target = "parent", source = "parent")
    @Mapping(target = "areaStructureType", source = "areaStructureType")
    AreaStructure toAreaStructure(AreaStructureCreateRequestDto createRequestDto, AreaStructure parent, AreaStructureType areaStructureType);

    @Mapping(target = "rootAreaId", source = "point.areaStructure.id")
    @Mapping(target = "areas", source = "allAreas")
    PointDto toPointWithAreasDto(Point point);


    DownloadResponse toDownloadResponse(byte[] file, String fileName);

    @Mapping(target = "location", source = "point.areaStructure.name")
    CsvPointDto toCsvPointDto(Point point);

    List<CsvPointDto> toCsvPointDto(Collection<Point> point);

    List<Point> toPoint(List<CsvPointDto> csvPoints);

    Point toPoint(CsvPointDto csvPoint);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "pointType", ignore = true)
    @Mapping(target = "name", source = "csvPoint.name")
    @Mapping(target = "creator", source = "employee")
    @Mapping(target = "pointState", source = "pointState")
    Point toPoint(CsvPointDto csvPoint, PointState pointState, Employee employee);

    @Mapping(target = "creator", source = "employee")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "areaStructure", source = "area")
    @Mapping(target = "pointType")
    void updatePoint(@MappingTarget Point point, PointUpdateRequest request, PointType pointType, AreaStructure area, Employee employee);

    AdministrativeUnitTypeDto toAdministrativeUnitTypeDto(AdministrativeUnitTypeDto administrativeUnitTypeDto);

    List<AdministrativeUnitTypeDto> toAdministrativeUnitTypeDto(List<AdministrativeUnitType> administrativeUnitTypes);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    AdministrativeUnitType toAdministrativeUnitType(AdministrativeUnitTypeCreateRequest request);

    List<AdministrativeUnitTreeDto> toAdministrativeUnitTreeDto(List<AdministrativeUnit> administrativeUnits);

    AdministrativeUnitTreeDto toAdministrativeUnitTreeDto(AdministrativeUnit administrativeUnit);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "administrativeUnitType", source = "administrativeUnitType")
    AdministrativeUnit toAdministrativeUnit(AdministrativeUnitCreateDto request, AdministrativeUnitType administrativeUnitType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "parent", source = "parent")
    @Mapping(target = "administrativeUnitType", source = "administrativeUnitType")
    AdministrativeUnit toAdministrativeUnit(AdministrativeUnitCreateDto request, AdministrativeUnit parent, AdministrativeUnitType administrativeUnitType);

    List<AdministrativeUnitDto> toAdministrativeUnitDto(List<AdministrativeUnit> structures);

    AdministrativeUnitDto toAdministrativeUnitDto(AdministrativeUnit administrativeUnit);

    CompetencyDto toCompetencyDto(Competency competency);

    List<CompetencyDto> toCompetencyDto(Collection<Competency> competencies);

    Competency toCompetency(CompetencyCreateRequest request);

    JobTitleDto toJobTitleDto(JobTitle jobTitle);

    List<JobTitleDto> toJobTitleDto(Collection<JobTitle> jobTitles);

    JobTitle toJobTitle(JobTitleCreateRequest request);

    EmployeeDto toEmployeeInfoDto(Employee employee);
}
