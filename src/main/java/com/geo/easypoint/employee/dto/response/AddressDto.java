package com.geo.easypoint.employee.dto.response;

public record AddressDto(String country,
                         String city,
                         String street,
                         String flat,
                         String postCode
) {
}
