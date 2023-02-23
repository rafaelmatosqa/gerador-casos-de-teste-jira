package model;

import lombok.Data;

@Data
public class TestCaseResponse {
    private Integer id;
    private String idTestcase;
    private String testCaseName;

    public TestCaseResponse(int id, String idTestcase, String testCaseName) {
        this.id = id;
        this.idTestcase = idTestcase;
        this.testCaseName = testCaseName;
    }
}
