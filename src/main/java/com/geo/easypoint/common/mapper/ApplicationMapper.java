package com.geo.easypoint.common.mapper;

import com.geo.easypoint.administrative.dto.AdminStructureTypeDto;
import com.geo.easypoint.administrative.dto.request.AdminStructureTypeCreateRequest;
import com.geo.easypoint.administrative.entity.AdminStructureType;
import com.geo.easypoint.area.dto.AreaDto;
import com.geo.easypoint.area.dto.AreaStructureDto;
import com.geo.easypoint.area.dto.AreaStructureTypeDto;
import com.geo.easypoint.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.area.dto.request.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.area.entity.AreaStructure;
import com.geo.easypoint.area.entity.AreaStructureType;
import com.geo.easypoint.common.DownloadResponse;
import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.employee.entity.WorkShiftType;
import com.geo.easypoint.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.employee.dto.response.EmployeeDto;
import com.geo.easypoint.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.point.dto.CsvPointDto;
import com.geo.easypoint.point.dto.PointCsvDto;
import com.geo.easypoint.point.dto.PointDto;
import com.geo.easypoint.point.dto.PointStateDto;
import com.geo.easypoint.point.dto.PointTypeDto;
import com.geo.easypoint.point.dto.request.PointCreateRequestDto;
import com.geo.easypoint.point.dto.request.PointUpdateRequest;
import com.geo.easypoint.tool.total.station.dto.TotalStationDto;
import com.geo.easypoint.tool.total.station.dto.request.TotalStationCreateRequestDto;
import com.geo.easypoint.users.dto.request.CreateUserRequest;
import com.geo.easypoint.users.dto.response.AuthenticationResponse;
import com.geo.easypoint.point.entity.Point;
import com.geo.easypoint.point.entity.PointState;
import com.geo.easypoint.point.entity.PointType;
import com.geo.easypoint.tool.total.station.entity.TotalStation;
import com.geo.easypoint.users.entity.EasyPointUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ApplicationMapper {
    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployee(CreateEmployeeRequest createEmployeeRequest);

    List<EmployeeDto> toEmployeeDto(Collection<Employee> employees);

    WorkShiftTypeDto toWorkShiftTypeDto(WorkShiftType workShiftType);

    List<WorkShiftTypeDto> toWorkShiftTypeDto(Collection<WorkShiftType> workShiftTypes);

    WorkShiftType toWorkShiftType(WorkShiftTypeCreateRequest workShiftTypeCreateRequest);


    EasyPointUser toEasyPointUser(CreateUserRequest request, String encodedPassword);

    @Mapping(target = "token", source = "jwtToken")
    AuthenticationResponse toAuthenticationResponse(EasyPointUser user, String jwtToken);

    PointDto toPointDto(Point point);

    List<PointDto> toPointDto(Collection<Point> points);

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
    @Mapping(target = "areaStructureType", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    AreaStructure toAreaStructure(AreaStructureCreateRequestDto createRequestDto);

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
    AreaStructure toAreaStructure(AreaStructureCreateRequestDto createRequestDto, AreaStructure parent);

    @Mapping(target = "rootAreaId", source = "point.areaStructure.id")
    @Mapping(target = "areas", source = "areas")
    PointDto toAreaDto(Point point, List<AreaDto> areas);

    @Mapping(target = "location", source = "point.areaStructure.name")
    PointCsvDto toPointCsv(Point point);

    List<PointCsvDto> toPointCsv(Collection<Point> points);

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

    AdminStructureTypeDto toAdminStructureTypeDto(AdminStructureTypeDto adminStructureTypeDto);
    List<AdminStructureTypeDto> toAdminStructureTypeDto(List<AdminStructureType> adminStructureTypes);

    AdminStructureType toAdminStructureType(AdminStructureTypeCreateRequest request);
}
