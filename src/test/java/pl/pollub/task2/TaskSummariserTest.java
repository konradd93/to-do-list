package pl.pollub.task2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskSummariserTest {

    @Mock
    UserService userService;

    @Mock
    EmailNotifier emailNotifier;

    @Mock
    TaskSummariser taskSummariser;

    @InjectMocks
    TaskService taskService;

    @Test
    public void whenTaskIsCompletedTaskSummariserShouldBeNotified() {
        Task task = taskService.createTaskForUser(1, 2, 3);

        when(userService.getUserById(anyInt())).thenAnswer(invocationOnMock -> {
            Integer id = invocationOnMock.getArgumentAt(0, int.class);
            return new User(id, "user" + id + "@wp.pl");
        });

        taskService.completeTask(1);

        Mockito.verify(taskSummariser).add(task);
    }
}
