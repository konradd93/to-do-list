package pl.pollub.service;

import pl.pollub.model.task.DTO.TaskDTO;
import pl.pollub.model.task.Task;

import java.util.List;

public interface TaskService {
    Task createTask(TaskDTO taskDTO);

    List<Task> getAllTasks();
}
