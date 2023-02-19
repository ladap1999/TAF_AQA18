package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Project {
    @Expose
    private String name;
    @Expose
    private String announcement;
    @Expose
    @SerializedName("show_announcement")
    private boolean showAnnouncement;
}
