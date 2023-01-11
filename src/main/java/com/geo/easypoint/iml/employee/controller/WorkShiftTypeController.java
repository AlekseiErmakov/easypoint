package com.geo.easypoint.iml.employee.controller;


import com.geo.easypoint.api.employee.dto.request.WorkShiftTypeCreateRequest;
import com.geo.easypoint.api.employee.dto.response.WorkShiftTypeDto;
import com.geo.easypoint.iml.employee.service.WorkShiftTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
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
