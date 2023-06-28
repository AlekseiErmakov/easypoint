package com.geo.easypoint.employees.workshifttype.web;


import com.geo.easypoint.employees.workshifttype.service.WorkShiftTypeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
