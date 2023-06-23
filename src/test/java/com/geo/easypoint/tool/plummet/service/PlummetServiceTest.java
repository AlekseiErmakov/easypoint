package com.geo.easypoint.tool.plummet.service;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.EasyPointAssertions;
import com.geo.easypoint.TestData;
import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.NotFoundException;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import com.geo.easypoint.tool.plummet.domain.PlummetRepository;
import com.geo.easypoint.tool.plummet.web.PlummetUpdateDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class PlummetServiceTest extends AbstractAppTest {

    @Mock
    private PlummetRepository plummetRepository;

    @InjectMocks
    private PlummetService plummetService;

    @Test
    void create() {
        Mockito.when(plummetRepository.existsByName(TestData.NAME))
                .thenReturn(false);
        plummetService.create(TestData.plummetCreateDto());

        EasyPointAssertions.assertThat(plummetRepository)
                .save(Plummet.builder()
                        .name(TestData.NAME)
                        .build());
    }

    @Test
    void failToCreateIfNameExists() {
        Mockito.when(plummetRepository.existsByName(TestData.NAME))
                .thenReturn(true);

        Assertions.assertThatThrownBy(() -> plummetService.create(TestData.plummetCreateDto()))
                .hasMessageContaining(TestData.NAME)
                .isInstanceOf(EasyPointLogicException.class);

        EasyPointAssertions.assertThat(plummetRepository)
                .neverSaveAny();
    }

    @Test
    void update() {
        String newName = "new name";

        Mockito.when(plummetRepository.existsByName(newName))
                .thenReturn(false);
        Mockito.when(plummetRepository.findById(TestData.ID))
                .thenReturn(Optional.of(TestData.plummet()));

        plummetService.update(TestData.ID, new PlummetUpdateDto(newName));

        EasyPointAssertions.assertThat(plummetRepository)
                .save(new Plummet(TestData.ID, newName));
    }


    @Test
    void failToUpdateOnNameExists() {
        String newName = "new name";

        Mockito.when(plummetRepository.existsByName(newName))
                .thenReturn(true);

        Assertions.assertThatThrownBy(() -> plummetService.update(TestData.ID, new PlummetUpdateDto(newName)))
                .hasMessageContaining(newName)
                .isInstanceOf(EasyPointLogicException.class);

        EasyPointAssertions.assertThat(plummetRepository)
                .neverSaveAny();
    }

    @Test
    void failToUpdateOnNotFound() {
        String newName = "new name";

        Mockito.when(plummetRepository.existsByName(newName))
                .thenReturn(false);
        Mockito.when(plummetRepository.findById(TestData.ID))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> plummetService.update(TestData.ID, new PlummetUpdateDto(newName)))
                .hasMessageContaining(TestData.ID.toString())
                .isInstanceOf(NotFoundException.class);

        EasyPointAssertions.assertThat(plummetRepository)
                .neverSaveAny();
    }

    @Test
    void deleteById() {
        Mockito.when(plummetRepository.findById(TestData.ID))
                .thenReturn(Optional.of(TestData.plummet()));

        plummetService.deleteById(TestData.ID);

        EasyPointAssertions.assertThat(plummetRepository)
                .delete(TestData.plummet());
    }

    @Test
    void failToDeleteOnIdNotFound() {
        Mockito.when(plummetRepository.findById(TestData.ID))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> plummetService.deleteById(TestData.ID))
                .hasMessageContaining(TestData.ID.toString())
                .isInstanceOf(NotFoundException.class);
    }

    @Test
    void findAll() {
        Mockito.when(plummetRepository.findAll())
                .thenReturn(List.of(TestData.plummet()));

        Assertions.assertThat(plummetService.findAll())
                .usingRecursiveComparison()
                .isEqualTo(TestData.plummetDto());
    }
}