package pl.pollub.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.model.project.DTO.ProjectDTO;
import pl.pollub.model.project.Project;
import pl.pollub.model.project.converter.ProjectDtoToEntityConverter;
import pl.pollub.repository.ProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectServiceImpl implements ProjectService {

    private final @NonNull ProjectRepository projectRepository;
    private final @NonNull ProjectDtoToEntityConverter projectDtoToEntityConverter;

    @Override
    public Project createProject(ProjectDTO projectDTO) {
        return projectRepository.save(projectDtoToEntityConverter.convert(projectDTO));
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
