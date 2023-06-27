package com.geo.easypoint.tool.state.web;

import lombok.Builder;
import org.openapitools.jackson.nullable.JsonNullable;

@Builder
public record ToolStateUpdateDto(JsonNullable<String> name, JsonNullable<String> description) {
}
