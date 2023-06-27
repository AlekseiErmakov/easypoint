package com.geo.easypoint.tool.state.service;

import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.common.mapper.PartialUpdater;
import com.geo.easypoint.tool.state.domain.ToolState;
import com.geo.easypoint.tool.state.domain.ToolStateRepository;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateDto;
import com.geo.easypoint.tool.state.web.ToolStateUpdateDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ToolStateService {

    private final ToolStateRepository toolStateRepository;

    @Transactional(readOnly = true)
    public List<ToolStateDto> findAll() {
        return EasyPointMapper.toToolStateDto(toolStateRepository.findAll());
    }

    @Transactional
    public ToolStateDto create(ToolStateCreateDto toolStateDto) {
        validateName(toolStateDto.name());
        return EasyPointMapper.toToolStateDto(toolStateRepository.save(EasyPointMapper.toToolState(toolStateDto)));
    }

    @Transactional
    public ToolStateDto update(ToolStateUpdateDto toolStateUpdateDto, Long id) {
        ToolState toolState = toolStateRepository.findById(id)
                .orElseThrow(() -> new EasyPointNotFoundException(id, ToolState.class));
        PartialUpdater.updater()
                .update(toolStateUpdateDto.name(), name -> {
                    validateName(name);
                    toolState.setName(name);
                })
                .update(toolStateUpdateDto.description(), toolState::setDescription);

        return EasyPointMapper.toToolStateDto(toolStateRepository.save(toolState));
    }

    @Transactional
    public void delete(Long id) {
        ToolState toolState = toolStateRepository.findById(id)
                .orElseThrow(() -> new EasyPointNotFoundException(id, ToolState.class));
        toolStateRepository.delete(toolState);
    }

    private void validateName(String name) {
        if (toolStateRepository.existsByName(name)) {
            throw new EasyPointLogicException("Tool state with name " + name + " already exists");
        }
    }
}
