package com.geo.easypoint.files;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BeanToCsvMapper {
    private static final CsvMapper CSV_MAPPER = new CsvMapper();

    static {
        SimpleModule validationModule = new SimpleModule();
        validationModule.setDeserializerModifier(new BeanDeserializerModifierWithValidation());
        CSV_MAPPER.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        CSV_MAPPER.registerModule(validationModule);
    }

    public static <T> byte[] toCsvFile(Collection<CsvColumn> columns, Collection<T> rows) {
        CsvSchema.Builder builder = CsvSchema.builder().setUseHeader(true);
        columns.forEach(column -> builder.addColumn(column.columnName(), column.columnType()));
        CsvSchema schema = builder.build();
        try (StringWriter strW = new StringWriter()) {
            CSV_MAPPER.writer(schema)
                    .writeValues(strW)
                    .writeAll(rows);
            return strW.toString()
                    .getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("Error while csv file creation! ", e);
            return new byte[0];
        }
    }

    public static <T> List<T> fromCsvFile(Collection<CsvColumn> columns, MultipartFile file, Class<T> clazz) {
        CsvSchema.Builder builder = CsvSchema.builder().setUseHeader(true);
        columns.forEach(column -> builder.addColumn(column.columnName(), column.columnType()));
        CsvSchema schema = builder.build();
        try {
            MappingIterator<T> objectMappingIterator = CSV_MAPPER
                    .readerFor(clazz)
                    .with(schema)
                    .readValues(file.getInputStream());
            List<T> lines = new ArrayList<>();
            while (objectMappingIterator.hasNext()) {
                T line = objectMappingIterator.next();
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            log.error("Error while csv file creation! ", e);
            throw new RuntimeException(e);
        }
    }

}
