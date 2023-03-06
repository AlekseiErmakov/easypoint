package com.geo.easypoint.impl.mapper;

import com.geo.easypoint.api.area.dto.AreaDto;
import com.geo.easypoint.api.area.dto.AreaStructureDto;
import com.geo.easypoint.api.area.dto.AreaStructureTypeDto;
import com.geo.easypoint.api.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.api.area.dto.request.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.api.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.api.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.api.employee.dto.response.EmployeeDto;
import com.geo.easypoint.api.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.api.point.dto.PointDto;
import com.geo.easypoint.api.point.dto.PointStateDto;
import com.geo.easypoint.api.point.dto.PointTypeDto;
import com.geo.easypoint.api.point.dto.request.PointCreateRequestDto;
import com.geo.easypoint.api.tool.total.station.TotalStationDto;
import com.geo.easypoint.api.tool.total.station.request.TotalStationCreateRequestDto;
import com.geo.easypoint.api.users.response.AuthenticationResponse;
import com.geo.easypoint.impl.area.entity.AreaStructure;
import com.geo.easypoint.impl.area.entity.AreaStructureType;
import com.geo.easypoint.impl.employee.entity.Employee;
import com.geo.easypoint.impl.employee.entity.WorkShiftType;
import com.geo.easypoint.impl.point.entity.Point;
import com.geo.easypoint.impl.point.entity.PointState;
import com.geo.easypoint.impl.point.entity.PointType;
import com.geo.easypoint.impl.tool.total.station.entity.TotalStation;
import com.geo.easypoint.impl.users.entity.EasyPointUser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;

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

    public static Employee toEmployee(CreateEmployeeRequest createEmployeeRequest) {
        return APPLICATION_MAPPER.toEmployee(createEmployeeRequest);
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

    public static List<PointDto> toPointDto(Collection<Point> points) {
        return APPLICATION_MAPPER.toPointDto(points);
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

    public static AreaStructure toAreaStructure(AreaStructureCreateRequestDto request) {
        return APPLICATION_MAPPER.toAreaStructure(request);
    }

    public static List<AreaDto> toAreaDto(List<AreaStructure> areas) {
        return APPLICATION_MAPPER.toAreaDto(areas);
    }

    public static AreaDto toAreaDto(AreaStructure area) {
        return APPLICATION_MAPPER.toAreaDto(area);
    }

    public static AreaStructure toAreaStructureType(AreaStructureCreateRequestDto createRequestDto, AreaStructure parent) {
        return APPLICATION_MAPPER.toAreaStructure(createRequestDto, parent);
    }

    public static List<PointDto> toPointDto(List<Point> all, Function<Point, List<AreaDto>> function) {
        return  all.stream()
                .map(point -> APPLICATION_MAPPER.toAreaDto(point, function.apply(point)))
                .collect(Collectors.toList());
    }
}
