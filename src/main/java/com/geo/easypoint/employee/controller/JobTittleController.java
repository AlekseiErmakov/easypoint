package com.geo.easypoint.employee.controller;


import com.geo.easypoint.employee.dto.request.JobTitleCreateRequest;
import com.geo.easypoint.employee.dto.request.JobTitlePartialUpdateRequest;
import com.geo.easypoint.employee.dto.response.JobTitleDto;
import com.geo.easypoint.employee.service.JobTitleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/job-titles")
public class JobTittleController {
    private final JobTitleService service;

    @PostMapping
    public void createJobTitle(@RequestBody @Valid JobTitleCreateRequest request) {
        service.createJobTitle(request);
    }

    @PatchMapping("/{id}")
    public void updateJobTitle(@RequestBody JobTitlePartialUpdateRequest request,
                               @Positive @PathVariable(name = "id") Long id) {
        service.updateJobTitle(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteJobTitle(@PathVariable("id") Long id) {
        service.deleteJobTitle(id);
    }

    @GetMapping
    public List<JobTitleDto> findAll() {
        return service.findAll();
    }

}
