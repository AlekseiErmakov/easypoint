package com.geo.easypoint.justification.pointstate.web;

import com.geo.easypoint.justification.pointstate.service.PointStateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point-state")
public class PointStateController {
    private final PointStateService pointStateService;

    @GetMapping
    public List<PointStateDto> findAll() {
        return pointStateService.findAll();
    }
}
