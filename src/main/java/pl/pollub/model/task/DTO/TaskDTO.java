package pl.pollub.model.task.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.pollub.model.project.Project;
import pl.pollub.model.team.Team;
import pl.pollub.model.user.User;

@Data
@AllArgsConstructor
public class TaskDTO {

    private User owner;

    private final String content;

    private final Project project;

    private final Team contributors;

    private final boolean isDone = false;


}
