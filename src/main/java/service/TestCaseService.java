package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import datafactory.TestCaseDataFactory;
import model.TestCase;
import model.TestCaseResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static utilities.Utilities.toJson;

public class TestCaseService {


    public static List<TestCaseResponse> createTestCase(List<TestCase> testCase) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/config.properties"));

        List<TestCaseResponse> testIds = new ArrayList<>();
        for (TestCase aCase : testCase) {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(properties.getProperty("urlBase").concat("/v2/testcases"));
            request.setHeader("Authorization", properties.getProperty("token"));
            request.setHeader("Content-Type", "application/json");

            try {
                TestCaseDataFactory testCaseDataFactory = new TestCaseDataFactory();
                ObjectMapper objectMapper = new ObjectMapper();
                String requestBody = toJson(objectMapper, testCaseDataFactory.createTestCases(properties.getProperty("projectKey"),aCase));

                request.setEntity(new StringEntity(requestBody));
                HttpResponse response = client.execute(request);

                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == 201) {
                    JSONObject responseJson = new JSONObject(EntityUtils.toString(response.getEntity()));
                    testIds.add(new TestCaseResponse(responseJson.getString("key"), aCase.getName()));

                } else {
                    System.out.println("Failed to create test case: " + response.getStatusLine().getStatusCode() + response.getStatusLine().getReasonPhrase());

                }

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return testIds;

    }

    public static void generateFileWithTestMethodsAndTestCaseIds(List<TestCaseResponse> lista) {
        File file = new File("src/main/resources/files/test_cases_generated.txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < lista.size(); i++) {

                String text = "    @Test\n" +
                        "    @TestCase(key=\"" + lista.get(i).getIdTestcase() + "\")\n" +
                        "    public void test_" + lista.get(i).getTestCaseName() + "(){}\n\n";
                writer.write(text);
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

