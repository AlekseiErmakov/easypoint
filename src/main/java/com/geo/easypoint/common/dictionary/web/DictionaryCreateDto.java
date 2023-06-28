package com.geo.easypoint.common.dictionary.web;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@SuperBuilder
public class DictionaryCreateDto {
    @NotBlank
    private final String name;
    private final String description;
}
