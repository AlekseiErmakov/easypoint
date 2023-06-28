package com.geo.easypoint.tool.plummet.service;

import com.geo.easypoint.common.dictionary.service.BaseDictionaryService;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import com.geo.easypoint.tool.plummet.domain.PlummetRepository;
import com.geo.easypoint.tool.plummet.web.PlummetCreateDto;
import com.geo.easypoint.tool.plummet.web.PlummetDto;
import com.geo.easypoint.tool.plummet.web.PlummetUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class PlummetService extends BaseDictionaryService<Plummet, PlummetDto, PlummetCreateDto, PlummetUpdateDto> {

    public PlummetService(PlummetRepository plummetRepository, PlummetMapper plummetMapper) {
        super(plummetRepository, plummetMapper);
    }
}
