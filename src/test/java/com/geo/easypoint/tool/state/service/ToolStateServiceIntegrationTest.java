package com.geo.easypoint.tool.state.service;


import com.geo.easypoint.ServiceTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.tool.state.domain.ToolStateRepository;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateDto;
import com.geo.easypoint.tool.state.web.ToolStateUpdateDto;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;

public class ToolStateServiceIntegrationTest extends ServiceTest {

    @Autowired
    private ToolStateRepository toolStateRepository;
    @Autowired
    private ToolStateService toolStateService;

    @BeforeEach
    public void init() {
        toolStateRepository.deleteAllInBatch();
        toolStateRepository.save(TestData.toolState());
    }

    @Test
    @DisplayName("Save new tool state test")
    public void saveTest() {

        ToolStateCreateDto toolStateCreateDto = new ToolStateCreateDto("new name", "new description");
        ToolStateDto result = toolStateService.create(toolStateCreateDto);

        Assertions.assertThat(result)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(
                        ToolStateDto.builder()
                                .name(toolStateCreateDto.name())
                                .description(toolStateCreateDto.description())
                                .build()
                );

        Assertions.assertThat(result.id())
                .isNotNull();
    }

    @Test
    @DisplayName("Find all tool state test")
    public void findAllTest() {

        Assertions.assertThat(toolStateService.findAll())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(List.of(TestData.toolStateDto()));

    }

    @Test
    @DisplayName("Delete tool state test")
    public void deleteTest() {

        Long id = toolStateRepository.findAll().iterator().next().getId();
        toolStateService.delete(id);
        Assertions.assertThat(toolStateService.findAll())
                .isEmpty();

    }


    @Test
    @DisplayName("Update name tool state test")
    public void updateNameTest() {

        Long id = toolStateRepository.findAll().iterator().next().getId();
        ToolStateUpdateDto toolStateUpdateDto = new ToolStateUpdateDto(
                JsonNullable.of("new name"), JsonNullable.undefined()
        );

        ToolStateDto result = toolStateService.update(toolStateUpdateDto, id);

        Assertions.assertThat(result.name())
                .isEqualTo(toolStateUpdateDto.name().get());
        Assertions.assertThat(result.description())
                .isEqualTo(TestData.toolState().getDescription());
    }

}
