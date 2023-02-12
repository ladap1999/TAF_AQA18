package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Milestone {
    @Expose
    private String name;

    @Expose
    @EqualsAndHashCode.Exclude
    private int id;

    @Expose
    @SerializedName("refs")
    private String references;

    @Expose
    private String description;
    @ToString.Exclude

    @Expose
    @SerializedName("due_on")
    private int dueDate;

    @Expose
    @SerializedName("start_on")
    private int startDate;

    @Expose
    @SerializedName("started_on")
    @EqualsAndHashCode.Exclude
    private int startedOn;

    @Expose
    private int completed_on;

    @Expose
    @SerializedName("is_completed")
    private boolean isCompleted;

    @Expose
    @SerializedName("is_started")
    @EqualsAndHashCode.Exclude
    private boolean isStarted;
}

