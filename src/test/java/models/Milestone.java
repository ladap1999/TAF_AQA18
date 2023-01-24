package models;

import lombok.*;

/*@Setter
@Getter
@ToString
@EqualsAndHashCode*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Milestone {
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String name;
    private String references;
    private String description;
    @ToString.Exclude
    private boolean completed;
    }
