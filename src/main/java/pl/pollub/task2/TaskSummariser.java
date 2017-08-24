package pl.pollub.task2;

import lombok.Data;

import java.sql.Connection;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class TaskSummariser {
    private static volatile TaskSummariser instanceOfTaskSummariser = null;

    private Map<Task,ZonedDateTime> completedTasks = new HashMap<>();

    private final Connection databaseConnection = null;

    private final KindOfNotify kindOfNotify = KindOfNotify.EMAIL;

    private TaskSummariser() {
    }

    public static TaskSummariser getInstance() {
        if (instanceOfTaskSummariser == null) {
            synchronized (TaskSummariser.class) {
                    if (instanceOfTaskSummariser == null) {
                        instanceOfTaskSummariser = new TaskSummariser();
                    }
                }
            }
        return instanceOfTaskSummariser;
    }

    public void add(Task task){
        this.completedTasks.put(task, ZonedDateTime.now());
        notifyIsTaskCompleted();
    }

    private void notifyIsTaskCompleted() {
        NotifierFactory.createNotifier(kindOfNotify);
    }

    public Map<Task,ZonedDateTime> getCompletedTasks(){
        return this.completedTasks;
    }
}

