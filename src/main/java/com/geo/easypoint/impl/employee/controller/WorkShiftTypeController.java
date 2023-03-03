package com.geo.easypoint.impl.employee.controller;


import com.geo.easypoint.api.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.api.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.impl.employee.service.WorkShiftTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/work-shift-types")
public class WorkShiftTypeController {

    private final WorkShiftTypeService workShiftTypeService;


    @GetMapping
    public List<WorkShiftTypeDto> findAll() {
        return workShiftTypeService.findAll();
    }

    @PostMapping
    public WorkShiftTypeDto save(@RequestBody WorkShiftTypeCreateRequest workShiftTypeCreateRequest) {
        return workShiftTypeService.save(workShiftTypeCreateRequest);
    }
}
