package com.geo.easypoint.administrative.dto;

import java.util.List;

public record AdminStructureDto(Long id, String name, AdminStructureTypeDto adminStructureType, String description,
                                List<AdminStructureDto> children) {
}
