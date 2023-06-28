package com.geo.easypoint.employees.jobtitle.service;

import com.geo.easypoint.common.dictionary.service.DictionaryMapper;
import com.geo.easypoint.employees.jobtitle.web.JobTitleCreateDto;
import com.geo.easypoint.employees.jobtitle.domain.JobTitle;
import com.geo.easypoint.employees.jobtitle.web.JobTitleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobTitleMapper extends DictionaryMapper<JobTitle, JobTitleDto, JobTitleCreateDto> {
}
