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

        ToolStateCreateDto toolStateCreateDto = ToolStateCreateDto.builder()
                .name("new name")
                .description("new description")
                .build();
        ToolStateDto result = toolStateService.create(toolStateCreateDto);

        Assertions.assertThat(result)
                .usingRecursiveComparison()
                .ignoringFields("id", "created", "updated")
                .isEqualTo(
                        ToolStateDto.builder()
                                .name(toolStateCreateDto.getName())
                                .description(toolStateCreateDto.getDescription())
                                .build()
                );

        Assertions.assertThat(result.getId())
                .isNotNull();
    }

    @Test
    @DisplayName("Find all tool state test")
    public void findAllTest() {

        Assertions.assertThat(toolStateService.findAll())
                .usingRecursiveComparison()
                .ignoringFields("id", "created", "updated")
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
        ToolStateUpdateDto toolStateUpdateDto = ToolStateUpdateDto.builder()
                .name(JsonNullable.of("new name"))
                .description(JsonNullable.undefined())
                .build();

        ToolStateDto result = toolStateService.update(toolStateUpdateDto, id);

        Assertions.assertThat(result.getName())
                .isEqualTo(toolStateUpdateDto.getName().get());
        Assertions.assertThat(result.getDescription())
                .isEqualTo(TestData.toolState().getDescription());
    }

}
