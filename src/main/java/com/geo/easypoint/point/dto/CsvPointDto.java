package com.geo.easypoint.point.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CsvPointDto(
        @JsonProperty(value = PointCsvHeaders.LOCATION) String location,
        @JsonProperty(PointCsvHeaders.POINT_NAME) String name,
        @JsonProperty(PointCsvHeaders.X) BigDecimal x,
        @JsonProperty(PointCsvHeaders.Y) BigDecimal y,
        @JsonProperty(value = PointCsvHeaders.H) BigDecimal h
) {
}
