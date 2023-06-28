package com.geo.easypoint.common.dictionary.web;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@RequiredArgsConstructor
public class DictionaryDto {
    private final Long id;
    private final String name;
    private final String description;
    private final LocalDateTime created;
    private final LocalDateTime updated;
}
