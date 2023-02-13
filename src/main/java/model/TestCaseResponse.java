package model;

import lombok.Data;

@Data
public class TestCaseResponse {
    private String idTestcase;
    private String testCaseName;

    public TestCaseResponse(String idTestcase, String testCaseName) {
        this.idTestcase = idTestcase;
        this.testCaseName = testCaseName;
    }
}
