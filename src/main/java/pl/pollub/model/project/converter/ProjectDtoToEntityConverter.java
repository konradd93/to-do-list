package pl.pollub.model.project.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.pollub.model.project.DTO.ProjectDTO;
import pl.pollub.model.project.Project;

@Component
public class ProjectDtoToEntityConverter implements Converter<ProjectDTO,Project> {
    @Override
    public Project convert(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        return project;
    }
}
