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
import java.util.Scanner;

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

    public static String formatString(String input) {
        String cleanString = input.replaceAll("[^\\p{ASCII}]", "");
        Scanner scanner = new Scanner(cleanString);
        StringBuilder result = new StringBuilder();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.length() > 0) {
                char firstChar = word.charAt(0);
                result.append(Character.toUpperCase(firstChar)).append(word.substring(1));
            }
        }

        return result.toString();
    }

}
