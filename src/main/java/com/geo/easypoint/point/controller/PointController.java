package com.geo.easypoint.point.controller;

import com.geo.easypoint.point.dto.PointDto;
import com.geo.easypoint.point.dto.request.PointCreateRequestDto;
import com.geo.easypoint.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/point")
public class PointController {

    private final PointService service;

    @GetMapping
    public List<PointDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public PointDto create(@RequestBody PointCreateRequestDto request) {
        return service.createPoint(request);
    }

    @PostMapping("/{pointId}")
    public void delete(@PathVariable Long pointId) {
        service.delete(pointId);
    }

}
