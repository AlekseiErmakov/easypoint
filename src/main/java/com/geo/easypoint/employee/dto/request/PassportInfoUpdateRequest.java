package com.geo.easypoint.employee.dto.request;

import com.geo.easypoint.employee.entity.Sex;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;

public record PassportInfoUpdateRequest(JsonNullable<String> number,
                                        JsonNullable<LocalDate> birthDate,
                                        JsonNullable<Sex> sex,
                                        JsonNullable<LocalDate> issueDate,
                                        JsonNullable<LocalDate> expiredDate,
                                        JsonNullable<String> authority) {
}
