package pl.pollub.model.task;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pollub.model.task.converter.TaskDtoToEntityConverter;
import pl.pollub.model.team.Team;
import pl.pollub.model.user.User;
import pl.pollub.repository.TaskRepository;
import pl.pollub.service.EmailNotifier;
import pl.pollub.service.TaskService;
import pl.pollub.service.UserService;
import pl.pollub.service.impl.TaskServiceImpl;

import java.util.*;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskServiceImpl taskService;

    @Mock
    private TaskRepository taskRepositoryMock;

    @Mock
    private TaskDtoToEntityConverter taskDtoToEntityConverterMock;

    @Mock
    private UserService userService;

    @Mock
    private EmailNotifier emailNotifier;

    @Captor
    private ArgumentCaptor<List<String>> emailsCaptor;


    @Test
    public void sendEmailToOwnerAndContributors(){

        Task task = taskService.createTaskForUser(new User(1L),new Team(Arrays.asList(new User(2L),new User(3L))));

        when(userService.getUserById(anyLong())).thenAnswer(invocationOnMock -> {
            Integer id = invocationOnMock.getArgument(0);
            return new User("user" + id + "@wp.pl");
        });

        taskService.completeTask(task.getId());
        //check if email sent to users: [1,2,3]
        verify(emailNotifier).notify(Mockito.eq(task.getId()), emailsCaptor.capture());

        HashSet<String> notified = new HashSet<>(emailsCaptor.getValue());
        HashSet<String> expected = new HashSet<>(Arrays.asList("user1@wp.pl","user2@wp.pl","user3@wp.pl" ));

        Assert.assertEquals(expected,notified);
    }

}
