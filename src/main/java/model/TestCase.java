package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"name", "objective", "precondition"})
public class TestCase {

    private String projectKey;
    private String name;
    private String objective;
    private String precondition;

    public TestCase(String projectKey, String name, String objective, String precondition) {
        this.projectKey = projectKey;
        this.name = name;
        this.objective = objective;
        this.precondition = precondition;

    }
}
