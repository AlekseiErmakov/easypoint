package com.geo.easypoint.impl.tool.total.station.controller;

import com.geo.easypoint.api.tool.total.station.TotalStationDto;
import com.geo.easypoint.api.tool.total.station.request.TotalStationCreateRequestDto;
import com.geo.easypoint.impl.tool.total.station.service.TotalStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tool/total-station")
public class TotalStationController {
    private final TotalStationService totalStationService;

    @PostMapping
    public void create(@RequestBody TotalStationCreateRequestDto createRequest) {
        totalStationService.createTotalStation(createRequest);
    }

    @GetMapping
    public List<TotalStationDto> findAll() {
        return totalStationService.findAll();
    }

}
