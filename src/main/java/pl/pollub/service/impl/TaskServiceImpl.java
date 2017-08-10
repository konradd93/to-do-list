package pl.pollub.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.model.task.DTO.TaskDTO;
import pl.pollub.model.task.Task;
import pl.pollub.model.task.converter.TaskDtoToEntityConverter;
import pl.pollub.model.team.Team;
import pl.pollub.model.user.User;
import pl.pollub.repository.TaskRepository;
import pl.pollub.service.EmailNotifier;
import pl.pollub.service.TaskService;
import pl.pollub.service.UserService;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskServiceImpl implements TaskService {

    private final @NonNull TaskRepository taskRepository;
    private final @NonNull TaskDtoToEntityConverter taskDtoToEntityConverter;

    private final @NonNull UserService userService;

    private final @NonNull EmailNotifier emailNotifier;

    private final AtomicLong counter = new AtomicLong();

    @Override
    public Task createTaskForUser(User owner, Team contributors){
        Task task = new Task(owner,
                contributors != null ? contributors : new Team(Collections.emptyList()));
        taskRepository.save(task);

        return task;
    }

    @Override
    public void completeTask(Long taskId){
        Task task = taskRepository.findOne(taskId);
        Team contributors = task.getContributors();
        contributors.addcollaborator(task.getOwner());

        Set<String> emails = contributors.getCollaborators().stream()
                .map(User::getEmail)
                .collect(Collectors.toSet());

        emailNotifier.notify(taskId, emails);
    }


    @Override
    public Task createTask(TaskDTO taskDTO) {
        return taskRepository.save(taskDtoToEntityConverter.convert(taskDTO));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
