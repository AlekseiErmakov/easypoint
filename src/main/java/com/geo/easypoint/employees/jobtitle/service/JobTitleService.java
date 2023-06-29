package com.geo.easypoint.employees.jobtitle.service;

import com.geo.easypoint.common.dictionary.service.DictionaryService;
import com.geo.easypoint.employees.jobtitle.web.JobTitleCreateDto;
import com.geo.easypoint.employees.jobtitle.web.JobTitleDto;
import com.geo.easypoint.employees.jobtitle.domain.JobTitle;
import com.geo.easypoint.employees.jobtitle.domain.JobTitleRepository;
import com.geo.easypoint.employees.jobtitle.web.JobTitleUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class JobTitleService extends DictionaryService<JobTitle, JobTitleDto, JobTitleCreateDto, JobTitleUpdateDto> {

    private final JobTitleRepository jobTitleRepository;
    private final JobTitleMapper jobTitleMapper;

    public JobTitleService(JobTitleRepository jobTitleRepository, JobTitleMapper jobTitleMapper) {
        super(jobTitleRepository, jobTitleMapper);
        this.jobTitleRepository = jobTitleRepository;
        this.jobTitleMapper = jobTitleMapper;
    }
}