package com.geo.easypoint.point.controller;

import com.geo.easypoint.point.dto.PointStateDto;
import com.geo.easypoint.point.service.PointStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("point-state")
public class PointStateController {
    private final PointStateService pointStateService;

    @GetMapping
    public List<PointStateDto> findAll() {
        return pointStateService.findAll();
    }
}
