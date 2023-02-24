package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"name","precondition","objective","priorityId","statusId","labels","description"})
public class TestCase {

    private Integer projectId;
    private String name;
    private String objective;
    private String precondition;
    private Integer statusId;
    private Integer priorityId;
    private List<String> labels;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    public TestCase(Integer projectId, String name, String objective, String precondition, Integer statusId, Integer priorityId, List<String> labels,String description) {
        this.projectId = projectId;
        this.name = name;
        this.objective = objective;
        this.precondition = precondition;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.labels = labels;
        this.description = description;
    }
}
