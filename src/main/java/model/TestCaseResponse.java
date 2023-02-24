package model;

import lombok.Data;

@Data
public class TestCaseResponse {
    private Integer id;
    private String idTestcase;
    private String testCaseName;
    private String descriptionTestCase;

    public TestCaseResponse(int id, String idTestcase, String testCaseName, String descriptionTestCase) {
        this.id = id;
        this.idTestcase = idTestcase;
        this.testCaseName = testCaseName;
        this.descriptionTestCase = descriptionTestCase;
    }
}
