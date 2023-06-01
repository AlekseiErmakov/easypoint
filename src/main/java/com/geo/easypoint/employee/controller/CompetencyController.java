package com.geo.easypoint.employee.controller;

import com.geo.easypoint.employee.dto.CompetencyDto;
import com.geo.easypoint.employee.dto.request.CompetencyCreateRequest;
import com.geo.easypoint.employee.dto.request.CompetencyPartialUpdateRequest;
import com.geo.easypoint.employee.service.CompetencyService;
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
@RequestMapping("/competencies")
public class CompetencyController {

    private final CompetencyService service;

    @PostMapping
    public void createCompetency(@RequestBody @Valid CompetencyCreateRequest request) {
        service.createCompetency(request);
    }

    @PatchMapping("/{id}")
    public void updateCompetency(@RequestBody CompetencyPartialUpdateRequest request,
                                 @Positive @PathVariable(name = "id") Long id) {
        service.updateCompetency(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetency(@PathVariable("id") @Positive Long id) {
        service.deleteCompetency(id);
    }

    @GetMapping
    public List<CompetencyDto> findAll() {
        return service.findAll();
    }
}
