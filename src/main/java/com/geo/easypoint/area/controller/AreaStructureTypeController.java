package com.geo.easypoint.area.controller;

import com.geo.easypoint.area.dto.AreaStructureTypeDto;
import com.geo.easypoint.area.dto.request.AreaStructureTypeCreateRequestDto;
import com.geo.easypoint.area.service.AreaStructureTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/area-structure-types")
public class AreaStructureTypeController {
    private final AreaStructureTypeService areaStructureTypeService;

    @GetMapping
    public List<AreaStructureTypeDto> findAll() {
        return areaStructureTypeService.findAll();
    }

    @PostMapping
    public void create(@RequestBody AreaStructureTypeCreateRequestDto request) {
        areaStructureTypeService.create(request);
    }
}
