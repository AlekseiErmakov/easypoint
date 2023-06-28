package com.geo.easypoint.organizationstructure.area.structure.web;

import com.geo.easypoint.organizationstructure.area.structure.service.AreaStructureService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/areas")
public class AreaStructureController {
    private final AreaStructureService areaStructureService;

    @GetMapping("/structure")
    public List<AreaStructureDto> findAll() {
        return areaStructureService.findAll();
    }

    @GetMapping
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
