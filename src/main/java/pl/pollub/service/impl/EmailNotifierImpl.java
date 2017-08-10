package pl.pollub.service.impl;

import org.springframework.stereotype.Service;
import pl.pollub.service.EmailNotifier;

import java.util.Collection;

@Service
public class EmailNotifierImpl implements EmailNotifier {
    @Override
    public void notify(Long taskId, Collection<String> emails) {

    }
}
