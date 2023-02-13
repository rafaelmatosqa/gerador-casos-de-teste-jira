package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

@UtilityClass
public class Utilities {

    public static <T> String toJson(ObjectMapper objectMapper, T obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }


    public <T> List<T> csvFileConverterInJavaObjectList(String path, Class<T> classe) throws IOException {
        File csvFile = new File(path);

        CsvMapper csvMapper = new CsvMapper();

        CsvSchema csvSchema = csvMapper
                .typedSchemaFor(classe)
                .withHeader()
                .withColumnSeparator(',')
                .withComments();

        MappingIterator<T> objIter = csvMapper
                .readerFor(classe)
                .with(csvSchema)
                .readValues(csvFile);

        return objIter.readAll();
    }

}
