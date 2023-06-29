package com.geo.easypoint.common.dictionary.web;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geo.easypoint.employees.competency.web.CompetencyCreateDto;
import com.geo.easypoint.employees.competency.web.CompetencyUpdateDto;
import com.geo.easypoint.employees.jobtitle.web.JobTitleCreateDto;
import com.geo.easypoint.employees.jobtitle.web.JobTitleUpdateDto;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeCreateDto;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeUpdateDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeCreateDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeUpdateDto;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeCreateDto;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeUpdateDto;
import com.geo.easypoint.tool.plummet.web.PlummetCreateDto;
import com.geo.easypoint.tool.plummet.web.PlummetUpdateDto;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateUpdateDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Jacksonized
@SuperBuilder
@RequiredArgsConstructor
@JsonSubTypes({
        @JsonSubTypes.Type(name = DictionaryNames.AREA_STRUCTURE_TYPE, value = AreaStructureTypeUpdateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.ADMINISTRATIVE_UNIT_TYPE, value = AdministrativeUnitTypeUpdateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.COMPETENCY, value = CompetencyUpdateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.PLUMMET, value = PlummetUpdateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.WORK_SHIFT_TYPE, value = WorkShiftTypeUpdateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.JOB_TITLE, value = JobTitleUpdateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.TOOL_STATE, value = ToolStateUpdateDto.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dType", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
public class DictionaryUpdateDto {
    private final JsonNullable<String> name;
    private final JsonNullable<String> description;
}
