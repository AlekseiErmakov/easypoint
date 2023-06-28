package com.geo.easypoint.dictionary.web;

import com.geo.easypoint.BaseWebMvcTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.tool.state.service.ToolStateService;
import com.geo.easypoint.tool.state.web.ToolStateController;
import com.geo.easypoint.tool.state.web.ToolStateCreateDto;
import com.geo.easypoint.tool.state.web.ToolStateDto;
import com.geo.easypoint.tool.state.web.ToolStateUpdateDto;
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
class BaseDictionaryControllerTest extends BaseWebMvcTest {
    private static final String BASE_URL = "/tool-states";

    @MockBean
    private ToolStateService service;

    @Test
    @DisplayName("Find all tool states web mvc test")
    void findAllTest() throws Exception {
        ToolStateDto toolStateDto = TestData.toolStateDto();

        Mockito.when(service.findAll())
                .thenReturn(List.of(toolStateDto));

        webMvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(toolStateDto.getName()),
                                Matchers.containsString(toolStateDto.getDescription())
                        )));
    }

    @Test
    @DisplayName("Create tool states web mvc test")
    void createTest() throws Exception {
        ToolStateCreateDto toolStateCreateDto = TestData.toolStateCreateDto();

        Mockito.when(service.create(Mockito.any()))
                .thenReturn(TestData.toolStateDto());

        webMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .content(objectMapper.writeValueAsString(toolStateCreateDto))
                        .contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(toolStateCreateDto.getName()),
                                Matchers.containsString(toolStateCreateDto.getDescription())
                        )));
    }

    @Test
    @DisplayName("Update tool state web mvc test")
    void update() throws Exception {
        objectMapper.registerModule(new JsonNullableModule());
        ToolStateUpdateDto toolStateUpdateDto = ToolStateUpdateDto.builder()
                .name(JsonNullable.of(TestData.NAME))
                .description(JsonNullable.undefined())
                .build();
        ToolStateDto toolStateDto = TestData.toolStateDto();

        Mockito.when(service.update(Mockito.any(), Mockito.eq(TestData.ID)))
                .thenReturn(toolStateDto);

        webMvc.perform(MockMvcRequestBuilders.patch(BASE_URL + "/" + TestData.ID)
                        .content(objectMapper.writeValueAsString(toolStateUpdateDto))
                        .contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(toolStateDto.getName()),
                                Matchers.containsString(toolStateDto.getDescription())
                        )));
    }

    @Test
    @DisplayName("Delete tool state web mvc test")
    void delete() throws Exception {
        webMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + TestData.ID))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(service).delete(TestData.ID);
    }
}