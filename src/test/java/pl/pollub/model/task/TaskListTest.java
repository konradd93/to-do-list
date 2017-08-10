package pl.pollub.model.task;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollub.model.task.DTO.TaskDTO;
import pl.pollub.model.user.User;

@RestController
@RequestMapping("/api")
public class TaskListTest {

    @Test
    public void whenICreateNewTaskThenThisTaskIsOnTheTaskList() throws Exception {
        User owner = new User();

        TaskList taskList = new TaskList();
        Task created1 = taskList.add(new TaskDTO(owner,"task1",null,null));
        taskList.add(new TaskDTO(owner,"task2",null,null));

        assertEquals(2, taskList.getAllTasks().size());
        assertTrue(taskList.getAllTasks().contains(created1));
    }


    public void ICanRemoveExistingTask(){
        //given: user and a task
        User owner = new User();
        TaskList taskList = new TaskList();
        taskList.add(new TaskDTO(owner,"task1",null,null));

        //when: i remove it
        Task task = taskList.getAllTasks().get(0);

        //then: it diesappears
    }

}