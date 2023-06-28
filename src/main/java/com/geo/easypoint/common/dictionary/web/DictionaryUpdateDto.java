package com.geo.easypoint.common.dictionary.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Jacksonized
@SuperBuilder
@RequiredArgsConstructor
public class DictionaryUpdateDto {
    private final JsonNullable<String> name;
    private final JsonNullable<String> description;
}
