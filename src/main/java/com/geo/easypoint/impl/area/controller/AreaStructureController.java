package com.geo.easypoint.impl.area.controller;

import com.geo.easypoint.api.area.dto.AreaDto;
import com.geo.easypoint.api.area.dto.AreaStructureDto;
import com.geo.easypoint.api.area.dto.request.AreaStructureCreateRequestDto;
import com.geo.easypoint.api.area.dto.request.AreaStructureLinkRequest;
import com.geo.easypoint.impl.area.service.AreaStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/area-structure")
public class AreaStructureController {
    private final AreaStructureService areaStructureService;

    @GetMapping
    public List<AreaStructureDto> findAll() {
        return areaStructureService.findAll();
    }

    @GetMapping("/areas")
    public List<AreaDto> findAllAreas() {
        return areaStructureService.findAllAreas();
    }

    @PostMapping
    public void create(@RequestBody AreaStructureCreateRequestDto request) {
        areaStructureService.creteAreaStructure(request);
    }

    @PostMapping("/link")
    public void linkAreaStructure(@RequestBody AreaStructureLinkRequest request) {
        areaStructureService.linkStructure(request);
    }
}
