package com.geo.easypoint.iml.point.service;

import com.geo.easypoint.api.point.dto.PointDto;
import com.geo.easypoint.api.point.dto.request.PointCreateRequestDto;
import com.geo.easypoint.iml.mapper.EasyPointMapper;
import com.geo.easypoint.iml.point.entity.Point;
import com.geo.easypoint.iml.point.entity.PointStates;
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
                        pointTypeRepository.findById(request.pointTypeId()).get(),
                        pointStateRepository.findByCode(PointStates.CREATED)));
        return EasyPointMapper.toPointDto(point);
    }
}
