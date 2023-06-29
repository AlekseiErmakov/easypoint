package com.geo.easypoint.common.dictionary.web;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geo.easypoint.employees.competency.web.CompetencyDto;
import com.geo.easypoint.employees.jobtitle.web.JobTitleDto;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeDto;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeDto;
import com.geo.easypoint.tool.plummet.web.PlummetDto;
import com.geo.easypoint.tool.state.web.ToolStateDto;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@RequiredArgsConstructor
@JsonSubTypes({
        @JsonSubTypes.Type(name = DictionaryNames.AREA_STRUCTURE_TYPE, value = AreaStructureTypeDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.ADMINISTRATIVE_UNIT_TYPE, value = AdministrativeUnitTypeDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.COMPETENCY, value = CompetencyDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.PLUMMET, value = PlummetDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.WORK_SHIFT_TYPE, value = WorkShiftTypeDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.JOB_TITLE, value = JobTitleDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.TOOL_STATE, value = ToolStateDto.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dType", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
public class DictionaryDto {
    private final Long id;
    private final String name;
    private final String description;
    private final LocalDateTime created;
    private final LocalDateTime updated;
}
