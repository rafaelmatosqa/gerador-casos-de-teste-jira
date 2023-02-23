package datafactory;

import builder.TestCaseBuilder;
import model.TestCase;

public class TestCaseDataFactory {

    public TestCase createTestCases(String projectKey, TestCase testCase) {
        return new TestCaseBuilder()
                .withProjectKey(projectKey)
                .withName(testCase.getName())
                .withObjective(testCase.getObjective())
                .withPreCondition(testCase.getPrecondition())
                .withStatusId(testCase.getStatusId())
                .withPriorityId(testCase.getPriorityId())
                .withLabels(testCase.getLabels())
                .build();
    }
}
