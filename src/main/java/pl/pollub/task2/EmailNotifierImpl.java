package pl.pollub.task2;

import java.util.Collection;
import java.util.HashSet;

public class EmailNotifierImpl implements EmailNotifier {

    private Collection<String> notified = new HashSet<>();

    @Override
    public void notify(int taskId, Collection<String> emails) {
        notified.addAll(emails);
    }

    @Override
    public Collection<String> getNotifiedEmails(){
        return notified;
    }
}
