package com.geo.easypoint.employee.dto.request;

import org.openapitools.jackson.nullable.JsonNullable;

public record CompetencyPartialUpdateRequest(JsonNullable<String> name,
                                             JsonNullable<String> description) {

}
