package com.geo.easypoint.tool.plummet.web;

import com.geo.easypoint.common.dictionary.web.BaseDictionaryController;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import com.geo.easypoint.tool.plummet.service.PlummetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plummets")
public class PlummetController extends BaseDictionaryController<Plummet, PlummetDto, PlummetCreateDto, PlummetUpdateDto> {
    public PlummetController(PlummetService service) {
        super(service);
    }
}
