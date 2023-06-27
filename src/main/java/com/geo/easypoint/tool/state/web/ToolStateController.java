package com.geo.easypoint.tool.state.web;

import com.geo.easypoint.tool.state.service.ToolStateService;
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
@RequestMapping("/tool-states")
public class ToolStateController {
    private final ToolStateService toolStateService;


    @GetMapping
    public List<ToolStateDto> findAll() {
        return toolStateService.findAll();
    }

    @PostMapping
    public ToolStateDto create(@RequestBody ToolStateCreateDto request) {
        return toolStateService.create(request);
    }

    @PatchMapping("/{id}")
    public ToolStateDto update(@RequestBody ToolStateUpdateDto request, @PathVariable("id") Long id) {
        return toolStateService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        toolStateService.delete(id);
    }
}
