package com.geo.easypoint.point.controller;

import com.geo.easypoint.files.EasyPointFile;
import com.geo.easypoint.point.dto.PointDto;
import com.geo.easypoint.point.dto.request.PointCreateRequestDto;
import com.geo.easypoint.point.dto.request.PointUpdateRequest;
import com.geo.easypoint.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/points")
public class PointController {

    private final PointService pointService;

    @GetMapping
    public List<PointDto> findAll() {
        return pointService.findAll();
    }

    @GetMapping(value = "/csv", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> downloadCsv() {
        EasyPointFile file = pointService.findAllCsv();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; " + file.fileName())
                .body(file.fileContent());
    }

    @PostMapping("/csv")
    public void storePoints(MultipartFile file) {
        pointService.savePointsFromCsv(file);
    }

    @PostMapping
    public void create(@RequestBody PointCreateRequestDto request) {
         pointService.createPoint(request);
    }

    @PostMapping("/{pointId}")
    public void update(@RequestBody PointUpdateRequest request, @PathVariable(name = "pointId") Long pointId) {
        pointService.updatePoint(request, pointId);
    }

    @DeleteMapping("/{pointId}")
    public void delete(@PathVariable Long pointId) {
        pointService.delete(pointId);
    }

}
