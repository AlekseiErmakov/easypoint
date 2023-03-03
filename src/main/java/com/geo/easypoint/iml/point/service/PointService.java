package com.geo.easypoint.iml.point.service;

import com.geo.easypoint.api.point.dto.PointDto;
import com.geo.easypoint.api.point.dto.request.PointCreateRequestDto;
import com.geo.easypoint.iml.exception.BadRequestException;
import com.geo.easypoint.iml.exception.NotFoundException;
import com.geo.easypoint.iml.mapper.EasyPointMapper;
import com.geo.easypoint.iml.point.entity.Point;
import com.geo.easypoint.iml.point.entity.PointStates;
import com.geo.easypoint.iml.point.entity.PointType;
import com.geo.easypoint.iml.point.repository.PointRepository;
import com.geo.easypoint.iml.point.repository.PointStateRepository;
import com.geo.easypoint.iml.point.repository.PointTypeRepository;
import com.geo.easypoint.iml.utill.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;
    private final PointTypeRepository pointTypeRepository;
    private final PointStateRepository pointStateRepository;

    @Transactional(readOnly = true)
    public List<PointDto> findAll() {
        return EasyPointMapper.toPointDto(pointRepository.findAll());
    }

    @Transactional
    public PointDto createPoint(PointCreateRequestDto request) {
        Point point = pointRepository.saveAndFlush(
                EasyPointMapper.toPoint(
                        request,
                        UserUtils.getCurrentEmployee(),
                        findPointType(request.pointTypeId()),
                        pointStateRepository.findByCode(PointStates.CREATED)));
        return EasyPointMapper.toPointDto(point);
    }

    public void delete(Long pointId) {
        Point point = findPoint(pointId);
        if (isNotPossibleToDelete(point.getPointState().getCode())) {
            throw new BadRequestException(String.format(
                    "Point %s can't be deleted. It has state %s, that is not allowed for deletion",
                    point.getName(), point.getPointState().getName())
            );
        }
        pointRepository.delete(point);
    }

    private Point findPoint(Long id) {
        return pointRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, Point.class));
    }

    private PointType findPointType(Long id){
        return pointTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, PointType.class));
    }

    private boolean isNotPossibleToDelete(PointStates pointState) {
        return PointStates.CREATED != pointState;
    }
}
