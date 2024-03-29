package com.geo.easypoint.tool.totalstation.web;

import com.geo.easypoint.tool.totalstation.service.TotalStationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tools/total-stations")
public class TotalStationController {

    private final TotalStationService totalStationService;

    @PostMapping
    public TotalStationDto create(@RequestBody TotalStationCreateRequestDto request) {
        return totalStationService.createTotalStation(request);
    }

    @PatchMapping("/{id}")
    public TotalStationDto update(@RequestBody TotalStationUpdateDto request, @PathVariable("id") Long id) {
        return totalStationService.updateTotalStation(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        totalStationService.delete(id);
    }

    @GetMapping
    public List<TotalStationDto> findAll() {
        return totalStationService.findAll();
    }

}
