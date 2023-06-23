package com.geo.easypoint.tool.plummet.web;

import jakarta.validation.constraints.NotBlank;

public record PlummetUpdateDto(@NotBlank String name) {
}
