package com.geo.easypoint.employees.workshifttype.service;

import com.geo.easypoint.common.dictionary.service.DictionaryService;
import com.geo.easypoint.common.mapper.PartialUpdater;
import com.geo.easypoint.employees.workshifttype.domain.WorkShiftType;
import com.geo.easypoint.employees.workshifttype.domain.WorkShiftTypeRepository;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeCreateDto;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeDto;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class WorkShiftTypeService extends DictionaryService<WorkShiftType, WorkShiftTypeDto, WorkShiftTypeCreateDto, WorkShiftTypeUpdateDto> {

    public WorkShiftTypeService(WorkShiftTypeRepository repository, WorkShiftTypeMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected void updateExtraProperties(WorkShiftTypeUpdateDto updateRequest, WorkShiftType dictionary) {
        PartialUpdater.updater()
                .update(updateRequest.getShortname(), dictionary::setShortname)
                .update(updateRequest.getEndHour(), dictionary::setEndHour)
                .update(updateRequest.getStartHour(), dictionary::setStartHour)
                .update(updateRequest.getEndMinute(), dictionary::setEndMinute)
                .update(updateRequest.getStartMinute(), dictionary::setStartMinute);
    }
}
