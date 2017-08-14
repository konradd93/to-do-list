package pl.pollub.task2;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> users = new ArrayList<>();

    public void createUser(User user){
        if (user != null)
            users.add(user);
    }

    public User getUserById(int userId){
        return users.get(userId);
    }
}
