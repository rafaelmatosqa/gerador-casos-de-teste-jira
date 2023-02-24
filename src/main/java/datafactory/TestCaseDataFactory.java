package datafactory;

import builder.TestCaseBuilder;
import model.TestCase;

public class TestCaseDataFactory {

    public TestCase createTestCases(Integer projectId, TestCase testCase) {
        return new TestCaseBuilder()
                .withProjectId(projectId)
                .withName(testCase.getName())
                .withObjective(testCase.getObjective())
                .withPreCondition(testCase.getPrecondition())
                .withStatusId(testCase.getStatusId())
                .withPriorityId(testCase.getPriorityId())
                .withLabels(testCase.getLabels())
                .build();
    }
}
