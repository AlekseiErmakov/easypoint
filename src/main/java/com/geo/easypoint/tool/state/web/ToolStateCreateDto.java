package com.geo.easypoint.tool.state.web;

import lombok.Builder;

@Builder
public record ToolStateCreateDto(String name, String description) {
}
