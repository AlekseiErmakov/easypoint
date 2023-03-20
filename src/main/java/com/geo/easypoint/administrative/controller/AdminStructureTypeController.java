package com.geo.easypoint.administrative.controller;

import com.geo.easypoint.administrative.dto.AdminStructureTypeDto;
import com.geo.easypoint.administrative.dto.request.AdminStructureTypeCreateRequest;
import com.geo.easypoint.administrative.service.AdminStructureTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin-structure-types")
public class AdminStructureTypeController {
    private final AdminStructureTypeService service;

    @GetMapping
    public List<AdminStructureTypeDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody AdminStructureTypeCreateRequest request) {
        service.create(request);
    }
}
