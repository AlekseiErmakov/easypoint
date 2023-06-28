package com.geo.easypoint.justification.point.web;

import static com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType.NUMBER;
import static com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType.STRING_OR_LITERAL;
import com.geo.easypoint.common.files.CsvColumn;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PointCsvHeaders {
    public static final String LOCATION = "Location";
    public static final String POINT_NAME = "Point name";
    public static final String X = "x";
    public static final String Y = "y";
    public static final String H = "h";

    public static List<CsvColumn> getColumns() {
        return List.of(
                new CsvColumn(LOCATION, STRING_OR_LITERAL),
                new CsvColumn(POINT_NAME, STRING_OR_LITERAL),
                new CsvColumn(X, NUMBER),
                new CsvColumn(Y, NUMBER),
                new CsvColumn(H, NUMBER)
        );
    }
}



