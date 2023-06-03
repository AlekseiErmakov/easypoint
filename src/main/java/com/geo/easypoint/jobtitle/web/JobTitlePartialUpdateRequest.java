package com.geo.easypoint.jobtitle.web;

import org.openapitools.jackson.nullable.JsonNullable;

public record JobTitlePartialUpdateRequest(JsonNullable<String> name, JsonNullable<String> description) {
}
