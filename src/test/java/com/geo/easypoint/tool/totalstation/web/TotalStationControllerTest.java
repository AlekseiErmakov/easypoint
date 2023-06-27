package com.geo.easypoint.tool.totalstation.web;

import com.geo.easypoint.BaseWebMvcTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.tool.totalstation.service.TotalStationService;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TotalStationController.class)
@AutoConfigureMockMvc(addFilters = false)
class TotalStationControllerTest extends BaseWebMvcTest {

    private static final String BASE_URL = "/tools/total-stations";
    @MockBean
    private TotalStationService totalStationService;

    @Test
    void create() throws Exception {
        TotalStationCreateRequestDto request = TestData.totalStationCreateRequestDto();
        TotalStationDto response = TestData.totalStationDto();

        Mockito.when(totalStationService.createTotalStation(TestData.totalStationCreateRequestDto()))
                .thenReturn(response);

        webMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .contentType(CONTENT_TYPE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(response.firm()),
                                Matchers.containsString(response.model())
                        )));
    }

    @Test
    void update() throws Exception {
        objectMapper.registerModule(new JsonNullableModule());
        TotalStationUpdateDto request = TotalStationUpdateDto.builder()
                .firm(JsonNullable.of(TestData.FIRM))
                .model(JsonNullable.of(TestData.MODEL))
                .serialNumber(JsonNullable.of(TestData.SERIAL_NUMBER))
                .build();
        TotalStationDto totalStationDto = TestData.totalStationDto();

        Mockito.when(totalStationService.updateTotalStation(request, TestData.ID))
                .thenReturn(TestData.totalStationDto());

        webMvc.perform(MockMvcRequestBuilders.patch(BASE_URL + "/" + TestData.ID)
                        .contentType(CONTENT_TYPE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(totalStationDto.firm()),
                                Matchers.containsString(totalStationDto.model())
                        )));
    }

    @Test
    void delete() throws Exception {
        webMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + TestData.ID))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(totalStationService).delete(TestData.ID);
    }

    @Test
    @DisplayName("")
    void findAll() throws Exception {
        TotalStationDto totalStationDto = TestData.totalStationDto();
        Mockito.when(totalStationService.findAll())
                .thenReturn(List.of(totalStationDto));
        webMvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.allOf(Matchers.containsString(totalStationDto.firm()),
                                Matchers.containsString(totalStationDto.model()),
                                Matchers.containsString(totalStationDto.serialNumber())
                        )));
    }

}