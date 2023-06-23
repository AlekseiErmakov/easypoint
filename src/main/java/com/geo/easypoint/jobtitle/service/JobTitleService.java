package com.geo.easypoint.jobtitle.service;

import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.common.mapper.PartialUpdater;
import com.geo.easypoint.employee.entity.JobTitle;
import com.geo.easypoint.employee.repository.EmployeeRepository;
import com.geo.easypoint.jobtitle.domain.JobTitleRepository;
import com.geo.easypoint.jobtitle.web.JobTitleCreateRequest;
import com.geo.easypoint.jobtitle.web.JobTitleDto;
import com.geo.easypoint.jobtitle.web.JobTitlePartialUpdateRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JobTitleService {

    private final JobTitleRepository jobTitleRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public void createJobTitle(JobTitleCreateRequest request) {
        jobTitleRepository.save(EasyPointMapper.toJobTitle(request));
    }

    @Transactional
    public void updateJobTitle(JobTitlePartialUpdateRequest request, Long id) {
        JobTitle jobTitle = findJobTitle(id);
        PartialUpdater.updater()
                .update(request.name(), jobTitle::setName)
                .update(request.description(), jobTitle::setDescription);
        jobTitleRepository.save(jobTitle);
    }

    @Transactional
    public void deleteJobTitle(Long id) {
        JobTitle jobTitle = findJobTitle(id);
        if (employeeRepository.existsByJobTitle_Id(id)) {
            throw new EasyPointLogicException(
                    String.format("Job title %s can't be deleted, there are employees with this competency still",
                            jobTitle.getName())
            );
        }
        jobTitleRepository.delete(jobTitle);
    }

    @Transactional(readOnly = true)
    public List<JobTitleDto> findAll() {
        return EasyPointMapper.toJobTitleDto(jobTitleRepository.findAll());
    }


    private JobTitle findJobTitle(Long id) {
        return NotFoundException.orElseThrow(id, JobTitle.class, jobTitleRepository::findById);
    }
}
