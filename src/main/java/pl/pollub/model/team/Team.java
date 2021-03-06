package pl.pollub.model.team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pollub.model.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<User> collaborators;

    public List<User> addcollaborator(User newCollaborator){
        collaborators.add(newCollaborator);
        return collaborators;
    }

    public Team(List<User> collaborators) {
        this.collaborators = collaborators;
    }
}
