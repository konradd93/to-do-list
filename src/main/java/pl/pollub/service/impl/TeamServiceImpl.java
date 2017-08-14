package pl.pollub.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.model.team.DTO.TeamDTO;
import pl.pollub.model.team.Team;
import pl.pollub.model.team.converter.TeamDtoToEntityConverter;
import pl.pollub.repository.TeamRepository;
import pl.pollub.service.TeamService;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeamServiceImpl implements TeamService {

    private final @NonNull TeamRepository teamRepository;
    private final @NonNull TeamDtoToEntityConverter teamDtoToEntityConverter;

    @Override
    public Team createTeam(TeamDTO teamDTO) {
        return teamRepository.save(teamDtoToEntityConverter.convert(teamDTO));
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
