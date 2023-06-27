package com.geo.easypoint.point.service;

import com.geo.easypoint.area.structure.domain.AreaStructure;
import com.geo.easypoint.area.structure.domain.AreaStructureRepository;
import com.geo.easypoint.common.exception.BadRequestException;
import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.common.files.EasyPointFile;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.common.utill.UserUtils;
import com.geo.easypoint.point.domain.Point;
import com.geo.easypoint.point.domain.PointRepository;
import com.geo.easypoint.point.web.CsvPointDto;
import com.geo.easypoint.point.web.PointCreateRequestDto;
import com.geo.easypoint.point.web.PointCsvHeaders;
import com.geo.easypoint.point.web.PointDto;
import com.geo.easypoint.point.web.PointUpdateRequest;
import com.geo.easypoint.pointstate.domain.PointStateRepository;
import com.geo.easypoint.pointstate.domain.PointType;
import com.geo.easypoint.pointstate.domain.PointTypeRepository;
import com.geo.easypoint.pointstate.web.PointStates;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;
    private final PointTypeRepository pointTypeRepository;
    private final PointStateRepository pointStateRepository;
    private final AreaStructureRepository areaStructureRepository;

    @Transactional(readOnly = true)
    public List<PointDto> findAll() {
        return EasyPointMapper.toPointDto(pointRepository.findAll());
    }

    @Transactional(readOnly = true)
    public EasyPointFile findAllCsv() {
        List<CsvPointDto> csvPoints = EasyPointMapper.toCsvPointDto(pointRepository.findAll());
        return EasyPointMapper.toEasyPointCsvFile(PointCsvHeaders.getColumns(), csvPoints, "points.csv");
    }

    @Transactional
    public void savePointsFromCsv(MultipartFile file) {
        List<CsvPointDto> csvPoints = EasyPointMapper.fromFileToElements(PointCsvHeaders.getColumns(), file, CsvPointDto.class);
        pointRepository.saveAll(EasyPointMapper.toPoint(csvPoints, pointStateRepository.findByCode(PointStates.CREATED), UserUtils.getCurrentEmployee()));
    }

    @Transactional
    public void createPoint(PointCreateRequestDto request) {
        pointRepository.saveAndFlush(
                EasyPointMapper.toPoint(
                        request,
                        UserUtils.getCurrentEmployee(),
                        findPointType(request.pointTypeId()),
                        pointStateRepository.findByCode(PointStates.CREATED),
                        EasyPointNotFoundException.orElseThrow(request.pointAreaId(), AreaStructure.class, areaStructureRepository::findById)
                )
        );
    }

    @Transactional
    public void updatePoint(PointUpdateRequest request, Long pointId) {
        Point point = findPoint(pointId);
        EasyPointMapper.updatePoint(point, request, findPointType(request.pointTypeId()), EasyPointNotFoundException.orElseThrow(request.pointAreaId(), AreaStructure.class, areaStructureRepository::findById),
                UserUtils.getCurrentEmployee());
        pointRepository.save(point);

    }

    @Transactional
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
                .orElseThrow(() -> new EasyPointNotFoundException(id, Point.class));
    }

    private PointType findPointType(Long id) {
        return pointTypeRepository.findById(id)
                .orElseThrow(() -> new EasyPointNotFoundException(id, PointType.class));
    }


    private boolean isNotPossibleToDelete(PointStates pointState) {
        return PointStates.CREATED != pointState;
    }

}
