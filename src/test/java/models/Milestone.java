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
    @EqualsAndHashCode.Exclude
    private String references;

    @Expose
    private String description;
    @ToString.Exclude

    @Expose
    @SerializedName("due_on")
    @EqualsAndHashCode.Exclude
    private int dueDate;

    @Expose
    @SerializedName("start_on")
    @EqualsAndHashCode.Exclude
    private long startDate;

    @Expose
    @SerializedName("started_on")
    @EqualsAndHashCode.Exclude
    private long startedOn;

    @Expose
    @EqualsAndHashCode.Exclude
    private int completed_on;

    @Expose
    @SerializedName("is_completed")
    private boolean isCompleted;

    @Expose
    @SerializedName("is_started")
    private boolean isStarted;
}

