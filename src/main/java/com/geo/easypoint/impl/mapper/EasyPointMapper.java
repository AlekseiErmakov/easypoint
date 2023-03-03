package com.geo.easypoint.impl.mapper;

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

    public static Point toPoint(PointCreateRequestDto request, Employee employee, PointType pointType, PointState pointState) {
        return APPLICATION_MAPPER.toPoint(request, employee, pointType, pointState);
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

    public static List<TotalStationDto> toTotalStationDto(Collection<TotalStation> totalStations){
        return APPLICATION_MAPPER.toTotalStationDto(totalStations);
    }

    public static TotalStation toTotalStation(TotalStationCreateRequestDto createRequestDto){
        return APPLICATION_MAPPER.toTotalStation(createRequestDto);
    }
}
