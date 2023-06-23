package com.geo.easypoint.administrative.unit.web;

import com.geo.easypoint.administrative.unit.service.AdministrativeUnitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/administrative-units")
public class AdministrativeUnitController {

    private final AdministrativeUnitService adminStructureService;

    @GetMapping("/structure")
    public List<AdministrativeUnitTreeDto> findStructure() {
        return adminStructureService.findAll();
    }

    @PostMapping
    public void create(@RequestBody AdministrativeUnitCreateDto request) {
        adminStructureService.creteAreaStructure(request);
    }

    @GetMapping
    public List<AdministrativeUnitDto> findAll() {
        return adminStructureService.findAllAdmins();
    }
}
