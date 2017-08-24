package pl.pollub.task2;

import java.util.Collection;

public interface EmailNotifier extends Notifier {

    Collection<String> getNotifiedEmails();
}
