package pl.pollub.service;

import java.util.Collection;

public interface EmailNotifier {

    void notify(Long taskId, Collection<String> emails);

}
