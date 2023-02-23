package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"name", "objective", "precondition"})
public class TestCase {

    private String projectKey;
    private String name;
    private String objective;
    private String precondition;
    private Integer statusId;
    private Integer priorityId;
    private List<String> labels;

    public TestCase(String projectKey, String name, String objective, String precondition, Integer statusId, Integer priorityId, List<String> labels) {
        this.projectKey = projectKey;
        this.name = name;
        this.objective = objective;
        this.precondition = precondition;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.labels = labels;
    }
}
