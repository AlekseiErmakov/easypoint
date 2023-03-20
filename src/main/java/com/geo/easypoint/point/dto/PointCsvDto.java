package com.geo.easypoint.point.dto;

import com.opencsv.bean.CsvBindAndJoinByPosition;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class PointCsvDto{
        @CsvBindByPosition(position = 0) private final String location;
        @CsvBindByPosition(position = 1) private final String name;
        @CsvBindByPosition(position = 2) private final BigDecimal x;
        @CsvBindByPosition(position = 3) private final BigDecimal y;
        @CsvBindByPosition(position = 4) private final BigDecimal h;
}
