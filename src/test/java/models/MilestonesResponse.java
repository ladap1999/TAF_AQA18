package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MilestonesResponse {
    @Expose
    private int offset;
    @Expose
    private int limit;
    @Expose
    private Milestone[] milestones;
}
