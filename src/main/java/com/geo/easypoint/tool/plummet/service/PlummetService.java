package com.geo.easypoint.tool.plummet.service;

import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import com.geo.easypoint.tool.plummet.domain.PlummetRepository;
import com.geo.easypoint.tool.plummet.web.PlummetCreateDto;
import com.geo.easypoint.tool.plummet.web.PlummetDto;
import com.geo.easypoint.tool.plummet.web.PlummetUpdateDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlummetService {

    private final PlummetRepository plummetRepository;

    @Transactional
    public void create(PlummetCreateDto plummetCreateDto) {
        if (plummetRepository.existsByName(plummetCreateDto.name())) {
            throw new EasyPointLogicException(String.format("Plummet with name %n already exists"));
        }
        plummetRepository.save(EasyPointMapper.toPlummet(plummetCreateDto));
    }

    @Transactional
    public void update(Long id, PlummetUpdateDto plummetUpdateDto) {
        if (plummetRepository.existsByName(plummetUpdateDto.name())) {
            throw new EasyPointLogicException(String.format("Plummet with name %n already exists"));
        }
        plummetRepository.save(
                NotFoundException.orElseThrow(id, Plummet.class, plummetRepository::findById)
                        .setName(plummetUpdateDto.name())
        );
    }

    @Transactional
    public void deleteById(Long id) {
        plummetRepository.delete(NotFoundException.orElseThrow(id, Plummet.class, plummetRepository::findById));
    }

    @Transactional(readOnly = true)
    public List<PlummetDto> findAll() {
        return EasyPointMapper.toPlummetDto(plummetRepository.findAll());
    }

}
