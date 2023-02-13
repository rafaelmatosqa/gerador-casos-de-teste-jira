package builder;

import model.TestCase;

public class TestCaseBuilder {

    private final TestCase testCase;

    public TestCaseBuilder() {
        testCase = new TestCase();
    }

    public TestCaseBuilder withProjectKey(String projectKey) {
        testCase.setProjectKey(projectKey);
        return this;
    }

    public TestCaseBuilder withName(String name) {
        testCase.setName(name);
        return this;
    }

    public TestCaseBuilder withObjective(String objective) {
        testCase.setObjective(objective);
        return this;
    }

    public TestCaseBuilder withPreCondition(String precondition) {
        testCase.setPrecondition(precondition);
        return this;
    }

    public TestCase build() {
        return testCase;
    }
}

