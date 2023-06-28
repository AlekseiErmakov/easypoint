package com.geo.easypoint.employees.jobtitle.web;


import com.geo.easypoint.common.dictionary.web.BaseDictionaryController;
import com.geo.easypoint.employees.jobtitle.domain.JobTitle;
import com.geo.easypoint.employees.jobtitle.service.JobTitleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

@RequestMapping("/job-titles")
public class JobTittleController extends BaseDictionaryController<JobTitle, JobTitleDto, JobTitleCreateDto, JobTitleUpdateDto> {
    public JobTittleController(JobTitleService service) {
        super(service);
    }
}
