package com.geo.easypoint.administrative.controller;

import com.geo.easypoint.administrative.dto.AdministrativeUnitDto;
import com.geo.easypoint.administrative.dto.AdministrativeUnitTreeDto;
import com.geo.easypoint.administrative.dto.request.AdministrativeUnitCreateRequest;
import com.geo.easypoint.administrative.service.AdministrativeUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void create(@RequestBody AdministrativeUnitCreateRequest request) {
        adminStructureService.creteAreaStructure(request);
    }

    @GetMapping
    public List<AdministrativeUnitDto> findAll() {
        return adminStructureService.findAllAdmins();
    }
}
