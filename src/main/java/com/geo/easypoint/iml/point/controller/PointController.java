package com.geo.easypoint.iml.point.controller;

import com.geo.easypoint.api.point.dto.PointDto;
import com.geo.easypoint.api.point.dto.request.PointCreateRequestDto;
import com.geo.easypoint.iml.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}
