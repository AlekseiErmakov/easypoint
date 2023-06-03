package com.geo.easypoint.pointtype.web;


import com.geo.easypoint.pointstate.service.PointTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/point-type")
public class PointTypeController {
    private final PointTypeService pointTypeService;

    @GetMapping
    public List<PointTypeDto> findAll() {
        return pointTypeService.findAll();
    }
}
