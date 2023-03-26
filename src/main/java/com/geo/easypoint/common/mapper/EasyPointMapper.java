package com.geo.easypoint.common.mapper;

import com.geo.easypoint.administrative.dto.AdminDto;
import com.geo.easypoint.administrative.dto.AdminStructureDto;
import com.geo.easypoint.administrative.dto.AdminStructureTypeDto;
import com.geo.easypoint.administrative.dto.request.AdminStructureCreateRequest;
import com.geo.easypoint.administrative.dto.request.AdminStructureTypeCreateRequest;
import com.geo.easypoint.administrative.entity.AdminStructure;
import com.geo.easypoint.administrative.entity.AdminStructureType;
import com.geo.easypoint.area.dto.AreaDto;
import com.geo.easypoint.area.dto.AreaStructureDto;
import com.geo.easypoint.area.dto.AreaStructureTypeDto;
import com.geo.easypoint.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.area.dto.request.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.area.entity.AreaStructure;
import com.geo.easypoint.area.entity.AreaStructureType;
import com.geo.easypoint.common.DownloadResponse;
import com.geo.easypoint.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.employee.dto.response.EmployeeDto;
import com.geo.easypoint.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.employee.entity.Employee;
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
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EasyPointMapper {
    private static final ApplicationMapper APPLICATION_MAPPER = Mappers.getMapper(ApplicationMapper.class);

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return APPLICATION_MAPPER.toEmployeeDto(employee);
    }

    public static List<EmployeeDto> toEmployeeDto(Collection<Employee> employees) {
        return APPLICATION_MAPPER.toEmployeeDto(employees);
    }

    public static Employee toEmployee(CreateEmployeeRequest createEmployeeRequest, List<AdminStructure> adminStructures) {
        return APPLICATION_MAPPER.toEmployee(createEmployeeRequest, adminStructures);
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
        return APPLICATION_MAPPER.toPointDto(point);
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

    public static List<PointDto> toPointDto(List<Point> all, Function<Point, List<AreaDto>> function) {
        return all.stream()
                .map(point -> APPLICATION_MAPPER.toAreaDto(point, function.apply(point)))
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

    public static List<AdminStructureTypeDto> toAdminStructureTypeDto(List<AdminStructureType> adminStructureTypes) {
        return APPLICATION_MAPPER.toAdminStructureTypeDto(adminStructureTypes);
    }

    public static AdminStructureType toAdminStructureType(AdminStructureTypeCreateRequest request) {
        return APPLICATION_MAPPER.toAdminStructureType(request);
    }

    public static List<AdminStructureDto> toAdminStructureDto(List<AdminStructure> adminStructures) {
        return APPLICATION_MAPPER.toAdminStructureDto(adminStructures);
    }

    public static AdminStructure toAdminStructure(AdminStructureCreateRequest request, AdminStructureType adminStructureType) {
        return APPLICATION_MAPPER.toAdminStructure(request, adminStructureType);
    }

    public static <T> AdminStructure toAdminStructure(AdminStructureCreateRequest request, AdminStructure parent, AdminStructureType adminStructureType) {
        return APPLICATION_MAPPER.toAdminStructure(request, parent, adminStructureType);
    }

    public static List<AdminDto> toAdminDto(List<AdminStructure> structures) {
        return APPLICATION_MAPPER.toAdminDto(structures);
    }
}
