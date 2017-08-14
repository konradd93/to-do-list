package pl.pollub.model.task.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.pollub.model.project.DTO.ProjectDTO;
import pl.pollub.model.project.Project;
import pl.pollub.model.task.DTO.TaskDTO;
import pl.pollub.model.task.Task;

@Component
public class TaskDtoToEntityConverter implements Converter<TaskDTO,Task> {

    @Override
    public Task convert(TaskDTO taskDTO) {
        Task task = new Task();
        task.setOwner(taskDTO.getOwner());
        task.setContent(taskDTO.getContent());
        task.setProject(taskDTO.getProject());
        task.setContributors(taskDTO.getContributors());
        task.setDone(taskDTO.isDone());
        return task;
    }
}
