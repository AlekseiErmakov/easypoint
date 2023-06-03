package com.geo.easypoint.point.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CsvPointDto(
        @NotBlank @JsonProperty(value = PointCsvHeaders.LOCATION) String location,
        @NotBlank @JsonProperty(PointCsvHeaders.POINT_NAME) String name,
        @NotNull @JsonProperty(PointCsvHeaders.X) BigDecimal x,
        @NotNull @JsonProperty(PointCsvHeaders.Y) BigDecimal y,
        @JsonProperty(value = PointCsvHeaders.H) BigDecimal h
) {
}
