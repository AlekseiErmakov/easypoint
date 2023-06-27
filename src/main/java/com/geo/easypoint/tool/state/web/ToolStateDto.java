package com.geo.easypoint.tool.state.web;

import lombok.Builder;

@Builder
public record ToolStateDto(Long id,
                           String name,
                           String description) {
}
