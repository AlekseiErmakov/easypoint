package com.geo.easypoint.competency.web;

import org.openapitools.jackson.nullable.JsonNullable;

public record CompetencyPartialUpdateRequest(JsonNullable<String> name,
                                             JsonNullable<String> description) {

}
