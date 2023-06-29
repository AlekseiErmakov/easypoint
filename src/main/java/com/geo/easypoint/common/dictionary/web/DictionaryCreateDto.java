package com.geo.easypoint.common.dictionary.web;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geo.easypoint.employees.competency.web.CompetencyCreateDto;
import com.geo.easypoint.employees.jobtitle.web.JobTitleCreateDto;
import com.geo.easypoint.employees.workshifttype.web.WorkShiftTypeCreateDto;
import com.geo.easypoint.organizationstructure.administrative.unittype.web.AdministrativeUnitTypeCreateDto;
import com.geo.easypoint.organizationstructure.area.structuretype.web.AreaStructureTypeCreateDto;
import com.geo.easypoint.tool.plummet.web.PlummetCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@JsonSubTypes({
        @JsonSubTypes.Type(name = DictionaryNames.AREA_STRUCTURE_TYPE, value = AreaStructureTypeCreateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.ADMINISTRATIVE_UNIT_TYPE, value = AdministrativeUnitTypeCreateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.COMPETENCY, value = CompetencyCreateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.PLUMMET, value = PlummetCreateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.WORK_SHIFT_TYPE, value = WorkShiftTypeCreateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.JOB_TITLE, value = JobTitleCreateDto.class),
        @JsonSubTypes.Type(name = DictionaryNames.TOOL_STATE, value = ToolStateCreateDto.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dType", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
public class DictionaryCreateDto {
    @NotBlank
    private final String name;
    private final String description;

    public DictionaryCreateDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
