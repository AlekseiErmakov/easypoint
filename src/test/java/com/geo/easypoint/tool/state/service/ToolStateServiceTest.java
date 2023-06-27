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

    @InjectMocks
    private ToolStateService toolStateService;

    @Test
    @DisplayName("Fetching all tool states")
    void findAll() {
        Mockito.when(toolStateRepository.findAll())
                .thenReturn(List.of(TestData.toolState()));

        Assertions.assertThat(toolStateService.findAll())
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.toolStateDto()));
    }

    @Test
    @DisplayName("Creating a tool state")
    void create() {
        ToolStateCreateDto toolStateCreateDto = TestData.toolStateCreateDto();

        Mockito.when(toolStateRepository.existsByName(toolStateCreateDto.name()))
                .thenReturn(false);
        Mockito.when(toolStateRepository.save(Mockito.any()))
                .thenReturn(TestData.toolState());

        Assertions.assertThat(toolStateService.create(toolStateCreateDto))
                .usingRecursiveComparison()
                .isEqualTo(TestData.toolStateDto());
    }

    @Test
    @DisplayName("Failed to create a tool state with existed name")
    void failedToCreateOnNameExist() {
        ToolStateCreateDto toolStateCreateDto = TestData.toolStateCreateDto();

        Mockito.when(toolStateRepository.existsByName(toolStateCreateDto.name()))
                .thenReturn(true);


        Assertions.assertThatThrownBy(() -> toolStateService.create(toolStateCreateDto))
                .isInstanceOf(EasyPointLogicException.class)
                .hasMessageContaining(toolStateCreateDto.name());

        Mockito.verify(toolStateRepository, Mockito.never()).save(Mockito.any());
    }

    @Test
    @DisplayName("Updating name of tool state")
    void updateName() {
        ToolStateUpdateDto toolStateUpdateDto = new ToolStateUpdateDto(JsonNullable.of("new name"), JsonNullable.undefined());
        ToolState currentToolState = Mockito.mock(ToolState.class);

        Mockito.when(toolStateRepository.existsByName(toolStateUpdateDto.name().get()))
                .thenReturn(false);
        Mockito.when(toolStateRepository.findById(TestData.ID))
                .thenReturn(Optional.of(currentToolState));

        toolStateService.update(toolStateUpdateDto, TestData.ID);

        Mockito.verify(toolStateRepository).save(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setDescription(Mockito.any());
        Mockito.verify(currentToolState).setName(toolStateUpdateDto.name().get());
    }

    @Test
    @DisplayName("Updating description of tool state")
    void updateDescription() {
        ToolStateUpdateDto toolStateUpdateDto = new ToolStateUpdateDto(JsonNullable.undefined(), JsonNullable.of("new"));
        ToolState currentToolState = Mockito.mock(ToolState.class);

        Mockito.when(toolStateRepository.findById(TestData.ID))
                .thenReturn(Optional.of(currentToolState));

        toolStateService.update(toolStateUpdateDto, TestData.ID);

        Mockito.verify(toolStateRepository, Mockito.never()).existsByName(Mockito.any());
        Mockito.verify(toolStateRepository).save(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setName(Mockito.any());
        Mockito.verify(currentToolState).setDescription(toolStateUpdateDto.description().get());
    }

    @Test
    @DisplayName("Fail to update existed name of tool state")
    void failToUpdateName() {
        ToolStateUpdateDto toolStateUpdateDto = new ToolStateUpdateDto(JsonNullable.of("new"), JsonNullable.undefined());
        ToolState currentToolState = Mockito.mock(ToolState.class);

        Mockito.when(toolStateRepository.findById(TestData.ID))
                .thenReturn(Optional.of(currentToolState));
        Mockito.when(toolStateRepository.existsByName(toolStateUpdateDto.name().get()))
                .thenReturn(true);

        Assertions.assertThatThrownBy(() -> toolStateService.update(toolStateUpdateDto, TestData.ID))
                .isInstanceOf(EasyPointLogicException.class)
                .hasMessageContaining(toolStateUpdateDto.name().get());

        Mockito.verify(toolStateRepository, Mockito.never()).save(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setName(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setDescription(Mockito.any());
    }

    @Test
    @DisplayName("Fail to update on not find")
    void failToUpdateOnNotFind() {
        ToolStateUpdateDto toolStateUpdateDto = new ToolStateUpdateDto(JsonNullable.of("new"), JsonNullable.undefined());
        ToolState currentToolState = Mockito.mock(ToolState.class);

        Mockito.when(toolStateRepository.findById(TestData.ID))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> toolStateService.update(toolStateUpdateDto, TestData.ID))
                .isInstanceOf(EasyPointNotFoundException.class)
                .hasMessageContaining(TestData.ID.toString());

        Mockito.verify(toolStateRepository, Mockito.never()).save(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setName(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setDescription(Mockito.any());
    }

    @Test
    @DisplayName("Deleting a tool state")
    void delete() {
        Mockito.when(toolStateRepository.findById(TestData.ID))
                .thenReturn(Optional.of(TestData.toolState()));

        toolStateService.delete(TestData.ID);

        Mockito.verify(toolStateRepository).delete(Mockito.any());
    }

    @Test
    @DisplayName("Fail to delete on not exist")
    void failToDelete() {
        Mockito.when(toolStateRepository.findById(TestData.ID))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> toolStateService.delete(TestData.ID))
                .isInstanceOf(EasyPointNotFoundException.class)
                .hasMessageContaining(TestData.ID.toString());

        Mockito.verify(toolStateRepository, Mockito.never()).delete(Mockito.any());
    }

}