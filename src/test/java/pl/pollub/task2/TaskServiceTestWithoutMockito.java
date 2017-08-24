package pl.pollub.task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashSet;

import java.util.Arrays;

public class TaskServiceTestWithoutMockito {

    UserService userService;
    EmailNotifier emailNotifier;
    TaskService taskService;

    @Before
    public void setUp(){
        emailNotifier = new EmailNotifierImpl();
        userService = new UserServiceImpl();
        taskService = new TaskService(userService,emailNotifier,TaskSummariser.getInstance());
    }

    @Test
    public void sendEmailToOwnerAndContributors(){

        createUsers(3);
        Task task = taskService.createTaskForUser(0,1,2);

        taskService.completeTask(1);

        String[] expected = new String[]{"user1@wp.pl","user2@wp.pl","user3@wp.pl"};

        Assert.assertThat(emailNotifier.getNotifiedEmails(),hasItems(expected));
    }

    private void createUsers(int numberOfUsers) {
        for(int i=0;i<numberOfUsers;i++) {
            userService.createUser(new User(i, "user" + (i+1) + "@wp.pl" ));
        }
    }
}
