package pl.pollub.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.model.task.DTO.TaskDTO;
import pl.pollub.model.task.Task;
import pl.pollub.model.task.converter.TaskDtoToEntityConverter;
import pl.pollub.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskServiceImpl implements TaskService {

    private final @NonNull TaskRepository taskRepository;
    private final @NonNull TaskDtoToEntityConverter taskDtoToEntityConverter;

    @Override
    public Task createTask(TaskDTO taskDTO) {
        return taskRepository.save(taskDtoToEntityConverter.convert(taskDTO));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
