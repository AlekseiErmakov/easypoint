package com.geo.easypoint.administrative.controller;

import com.geo.easypoint.administrative.dto.AdminDto;
import com.geo.easypoint.administrative.dto.AdminStructureDto;
import com.geo.easypoint.administrative.dto.request.AdminStructureCreateRequest;
import com.geo.easypoint.administrative.service.AdminStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminStructureController {

    private final AdminStructureService adminStructureService;

    @GetMapping("/structure")
    public List<AdminStructureDto> findAll() {
        return adminStructureService.findAll();
    }

    @PostMapping
    public void create(@RequestBody AdminStructureCreateRequest request) {
        adminStructureService.creteAreaStructure(request);
    }

    @GetMapping
    public List<AdminDto> findAllAdmins() {
        return adminStructureService.findAllAdmins();
    }
}
