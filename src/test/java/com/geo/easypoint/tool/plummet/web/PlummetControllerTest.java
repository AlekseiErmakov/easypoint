package com.geo.easypoint.tool.plummet.web;

import com.geo.easypoint.AbstractAppTest;
import com.geo.easypoint.TestData;
import com.geo.easypoint.tool.plummet.domain.Plummet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlummetControllerTest extends AbstractAppTest {
    @BeforeEach
    public void init() {
        plummetRepository.deleteAllInBatch();
    }

    @Test
    void create() {
        plummetController.create(TestData.plummetCreateDto());

        Assertions.assertThat(plummetRepository.existsByName(TestData.NAME))
                .isTrue();
    }

    @Test
    void updatePlummet() {
        String newName = "new name";

        plummetController.updatePlummet(TestData.ID, new PlummetUpdateDto(newName));

        Assertions.assertThat(plummetRepository.existsByName(newName))
                .isTrue();
    }

    @Test
    void deletePlummet() {
        Long id = saveNew();

        plummetController.deletePlummet(id);

        Assertions.assertThat(plummetRepository.findAll())
                .isEmpty();
    }

    @Test
    void findAll() {

        Long id = saveNew();

        PlummetDto plummetDto = plummetController.findAll().get(0);

        Assertions.assertThat(plummetDto.name())
                .isEqualTo(TestData.NAME);
        Assertions.assertThat(plummetDto.id())
                .isEqualTo(id);
    }

    private Long saveNew() {
        return plummetRepository.save(Plummet.builder().name(TestData.NAME).build()).getId();
    }
}