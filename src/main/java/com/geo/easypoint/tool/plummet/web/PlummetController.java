package com.geo.easypoint.tool.plummet.web;

import com.geo.easypoint.tool.plummet.service.PlummetService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plummets")
public class PlummetController {

    private final PlummetService plummetService;

    @PostMapping
    public void create(@RequestBody PlummetCreateDto plummetCreateDto) {
        plummetService.create(plummetCreateDto);
    }

    @PutMapping("/{id}")
    public void updatePlummet(@PathVariable("id") Long id, @RequestBody PlummetUpdateDto plummetUpdateDto) {
        plummetService.update(id, plummetUpdateDto);
    }


    @DeleteMapping("/{id}")
    public void deletePlummet(@PathVariable("id") Long id) {
        plummetService.deleteById(id);
    }

    @GetMapping
    public List<PlummetDto> findAll() {
        return plummetService.findAll();
    }
}
