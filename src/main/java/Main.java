import model.TestCase;
import model.TestCaseResponse;
import utilities.Utilities;

import java.io.IOException;
import java.util.List;


import static service.TestCaseService.createTestCase;
import static service.TestCaseService.generateFileWithTestMethodsAndTestCaseIds;

public class Main {

    public static void main(String[] args) throws IOException {
        List<TestCase> lista = Utilities.csvFileConverterInJavaObjectList("src/main/resources/files/test_cases.csv", TestCase.class);
        List<TestCaseResponse> listaIds = createTestCase(lista);
        generateFileWithTestMethodsAndTestCaseIds(listaIds);

    }
}
