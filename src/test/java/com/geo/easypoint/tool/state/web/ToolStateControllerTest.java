package com.geo.easypoint.tool.state.web;

import com.geo.easypoint.BaseWebMvcTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.tool.state.service.ToolStateService;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(value = {ToolStateController.class})
@AutoConfigureMockMvc(addFilters = false)
class ToolStateControllerTest extends BaseWebMvcTest {

    private static final String BASE_URL = "/tool-states";

    @MockBean
    private ToolStateService toolStateService;

    @Test
    @DisplayName("Find all tool states web mvc test")
    void findAllTest() throws Exception {
        ToolStateDto toolStateDto = TestData.toolStateDto();

        Mockito.when(toolStateService.findAll())
                .thenReturn(List.of(toolStateDto));

        webMvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(toolStateDto.name()),
                                Matchers.containsString(toolStateDto.description())
                        )));
    }

    @Test
    @DisplayName("Create tool states web mvc test")
    void createTest() throws Exception {
        ToolStateCreateDto toolStateCreateDto = TestData.toolStateCreateDto();

        Mockito.when(toolStateService.create(toolStateCreateDto))
                .thenReturn(TestData.toolStateDto());

        webMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .content(objectMapper.writeValueAsString(toolStateCreateDto))
                        .contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(toolStateCreateDto.name()),
                                Matchers.containsString(toolStateCreateDto.description())
                        )));
    }

    @Test
    @DisplayName("Update tool state web mvc test")
    void update() throws Exception {
        objectMapper.registerModule(new JsonNullableModule());
        ToolStateUpdateDto toolStateUpdateDto = new ToolStateUpdateDto(JsonNullable.of(TestData.NAME), JsonNullable.undefined());
        ToolStateDto toolStateDto = TestData.toolStateDto();

        Mockito.when(toolStateService.update(toolStateUpdateDto, TestData.ID))
                .thenReturn(toolStateDto);

        webMvc.perform(MockMvcRequestBuilders.patch(BASE_URL + "/" + TestData.ID)
                        .content(objectMapper.writeValueAsString(toolStateUpdateDto))
                        .contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(toolStateDto.name()),
                                Matchers.containsString(toolStateDto.description())
                        )));
    }

    @Test
    @DisplayName("Delete tool state web mvc test")
    void delete() throws Exception {
        webMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + TestData.ID))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(toolStateService).delete(TestData.ID);
    }

}