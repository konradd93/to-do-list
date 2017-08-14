package pl.pollub.model.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;
import pl.pollub.model.task.DTO.TaskDTO;
import pl.pollub.model.task.converter.TaskDtoToEntityConverter;

@Component
public class TaskList {

    private final List<Task> tasks = new ArrayList<>();

    private final AtomicInteger counter = new AtomicInteger();

    private final TaskDtoToEntityConverter taskDtoToEntityConverter = new TaskDtoToEntityConverter();

    /*public Task add(TaskDTO taskDTO){
        Task created = new Task(generateId(), taskDTO.getContent());
        tasks.add(created);
        return created;
    }
*/
    private int generateId() {
        return counter.incrementAndGet();
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task add(TaskDTO taskDTO) {
        Task taskEntity = taskDtoToEntityConverter.convert(taskDTO);
        tasks.add(taskEntity);
        return taskEntity;
    }
}
