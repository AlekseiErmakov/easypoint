package com.geo.easypoint.files;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public record CsvColumn(String columnName, CsvSchema.ColumnType columnType) {
}
