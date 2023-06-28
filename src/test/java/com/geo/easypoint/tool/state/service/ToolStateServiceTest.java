package com.geo.easypoint.tool.state.service;

import com.geo.easypoint.TestData;
import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.tool.state.domain.ToolState;
import com.geo.easypoint.tool.state.domain.ToolStateRepository;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateUpdateDto;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.jackson.nullable.JsonNullable;

@ExtendWith(MockitoExtension.class)
class ToolStateServiceTest {

    @Mock
    private ToolStateRepository toolStateRepository;
    @Mock
    private ToolStateMapper toolStateMapper;
    @InjectMocks
    private ToolStateService toolStateService;



}