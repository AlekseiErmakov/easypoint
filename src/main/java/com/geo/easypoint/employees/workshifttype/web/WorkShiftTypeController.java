package com.geo.easypoint.employees.workshifttype.web;


import com.geo.easypoint.common.dictionary.web.DictionaryController;
import com.geo.easypoint.employees.workshifttype.domain.WorkShiftType;
import com.geo.easypoint.employees.workshifttype.service.WorkShiftTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work-shift-types")
public class WorkShiftTypeController extends DictionaryController<WorkShiftType, WorkShiftTypeDto, WorkShiftTypeCreateDto, WorkShiftTypeUpdateDto> {

    public WorkShiftTypeController(WorkShiftTypeService workShiftTypeService) {
        super(workShiftTypeService);
    }
}
