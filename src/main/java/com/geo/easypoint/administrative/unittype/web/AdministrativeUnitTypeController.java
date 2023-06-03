package com.geo.easypoint.administrative.unittype.web;

import com.geo.easypoint.administrative.unittype.service.AdministrativeUnitTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/administrative-unit-types")
public class AdministrativeUnitTypeController {
    private final AdministrativeUnitTypeService service;

    @GetMapping
    public List<AdministrativeUnitTypeDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody AdministrativeUnitTypeCreateRequest request) {
        service.create(request);
    }
}
