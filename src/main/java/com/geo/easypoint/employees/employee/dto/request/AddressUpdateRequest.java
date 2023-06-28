package com.geo.easypoint.employees.employee.dto.request;

import org.openapitools.jackson.nullable.JsonNullable;

public record AddressUpdateRequest(
        JsonNullable<String> country,
        JsonNullable<String> city,
        JsonNullable<String> street,
        JsonNullable<String> flat,
        JsonNullable<String> postCode) {
}
