package com.geo.easypoint.area.structuretype.web;

import com.geo.easypoint.area.structuretype.service.AreaStructureTypeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
