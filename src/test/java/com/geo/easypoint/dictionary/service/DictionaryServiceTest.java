package com.geo.easypoint.dictionary.service;

import com.geo.easypoint.TestData;
import com.geo.easypoint.common.dictionary.service.DictionaryService;
import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.tool.state.domain.ToolState;
import com.geo.easypoint.tool.state.domain.ToolStateRepository;
import com.geo.easypoint.tool.state.service.ToolStateMapper;
import com.geo.easypoint.tool.state.service.ToolStateService;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateDto;
import com.geo.easypoint.tool.state.web.ToolStateUpdateDto;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.jackson.nullable.JsonNullable;

@ExtendWith(MockitoExtension.class)
class DictionaryServiceTest {

    private ToolStateRepository repository = Mockito.mock(ToolStateRepository.class);
    private ToolStateMapper mapper = Mockito.mock(ToolStateMapper.class);

    private DictionaryService<ToolState, ToolStateDto, ToolStateCreateDto, ToolStateUpdateDto> service = new ToolStateService(repository, mapper);

    @Test
    @DisplayName("Fetching all tool states")
    void findAll() {
        Mockito.when(repository.findAll())
                .thenReturn(List.of(TestData.toolState()));
        Mockito.when(mapper.toDto(Mockito.any()))
                .thenReturn(TestData.toolStateDto());
        Assertions.assertThat(service.findAll())
                .usingRecursiveComparison()
                .isEqualTo(List.of(TestData.toolStateDto()));
    }

    @Test
    @DisplayName("Creating a tool state")
    void create() {
        ToolStateCreateDto toolStateCreateDto = TestData.toolStateCreateDto();

        Mockito.when(repository.existsByName(toolStateCreateDto.getName()))
                .thenReturn(false);
        Mockito.when(repository.saveAndFlush(Mockito.any()))
                .thenReturn(TestData.toolState());
        Mockito.when(mapper.toEntity(Mockito.any()))
                .thenReturn(TestData.toolState());
        Mockito.when(mapper.toDto(Mockito.any()))
                .thenReturn(TestData.toolStateDto());

        Assertions.assertThat(service.create(toolStateCreateDto))
                .usingRecursiveComparison()
                .isEqualTo(TestData.toolStateDto());
    }

    @Test
    @DisplayName("Failed to create a tool state with existed name")
    void failedToCreateOnNameExist() {
        ToolStateCreateDto toolStateCreateDto = TestData.toolStateCreateDto();

        Mockito.when(repository.existsByName(toolStateCreateDto.getName()))
                .thenReturn(true);

        Assertions.assertThatThrownBy(() -> service.create(toolStateCreateDto))
                .isInstanceOf(EasyPointLogicException.class)
                .hasMessageContaining(toolStateCreateDto.getName());

        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }

    @Test
    @DisplayName("Updating name of tool state")
    void updateName() {
        ToolStateUpdateDto toolStateUpdateDto = ToolStateUpdateDto.builder()
                .name(JsonNullable.of("new name"))
                .description(JsonNullable.undefined())
                .build();
        ToolState currentToolState = Mockito.mock(ToolState.class);

        Mockito.when(repository.existsByName(toolStateUpdateDto.getName().get()))
                .thenReturn(false);
        Mockito.when(repository.findById(TestData.ID))
                .thenReturn(Optional.of(currentToolState));

        service.update(toolStateUpdateDto, TestData.ID);

        Mockito.verify(repository).save(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setDescription(Mockito.any());
        Mockito.verify(currentToolState).setName(toolStateUpdateDto.getName().get());
    }

    @Test
    @DisplayName("Updating description of tool state")
    void updateDescription() {
        ToolStateUpdateDto toolStateUpdateDto = ToolStateUpdateDto.builder()
                .name(JsonNullable.undefined())
                .description(JsonNullable.of("new"))
                .build();
        ToolState currentToolState = Mockito.mock(ToolState.class);

        Mockito.when(repository.findById(TestData.ID))
                .thenReturn(Optional.of(currentToolState));

        service.update(toolStateUpdateDto, TestData.ID);

        Mockito.verify(repository, Mockito.never()).existsByName(Mockito.any());
        Mockito.verify(repository).save(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setName(Mockito.any());
        Mockito.verify(currentToolState).setDescription(toolStateUpdateDto.getDescription().get());
    }

    @Test
    @DisplayName("Fail to update existed name of tool state")
    void failToUpdateName() {
        ToolStateUpdateDto toolStateUpdateDto = ToolStateUpdateDto.builder()
                .name(JsonNullable.of("new"))
                .description(JsonNullable.undefined())
                .build();
        ToolState currentToolState = Mockito.mock(ToolState.class);

        Mockito.when(repository.findById(TestData.ID))
                .thenReturn(Optional.of(currentToolState));
        Mockito.when(repository.existsByName(toolStateUpdateDto.getName().get()))
                .thenReturn(true);

        Assertions.assertThatThrownBy(() -> service.update(toolStateUpdateDto, TestData.ID))
                .isInstanceOf(EasyPointLogicException.class)
                .hasMessageContaining(toolStateUpdateDto.getName().get());

        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setName(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setDescription(Mockito.any());
    }

    @Test
    @DisplayName("Fail to update on not find")
    void failToUpdateOnNotFind() {
        ToolStateUpdateDto toolStateUpdateDto = ToolStateUpdateDto.builder()
                .name(JsonNullable.of("new"))
                .description(JsonNullable.undefined())
                .build();
        ToolState currentToolState = Mockito.mock(ToolState.class);

        Mockito.when(repository.findById(TestData.ID))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> service.update(toolStateUpdateDto, TestData.ID))
                .isInstanceOf(EasyPointNotFoundException.class)
                .hasMessageContaining(TestData.ID.toString());

        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setName(Mockito.any());
        Mockito.verify(currentToolState, Mockito.never()).setDescription(Mockito.any());
    }

    @Test
    @DisplayName("Deleting a tool state")
    void delete() {
        Mockito.when(repository.findById(TestData.ID))
                .thenReturn(Optional.of(TestData.toolState()));

        service.delete(TestData.ID);

        Mockito.verify(repository).delete(Mockito.any());
    }

    @Test
    @DisplayName("Fail to delete on not exist")
    void failToDelete() {
        Mockito.when(repository.findById(TestData.ID))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> service.delete(TestData.ID))
                .isInstanceOf(EasyPointNotFoundException.class)
                .hasMessageContaining(TestData.ID.toString());

        Mockito.verify(repository, Mockito.never()).delete(Mockito.any());
    }
}