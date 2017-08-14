package pl.pollub.task2;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepository();

    @Override
    public User createUser(User user) {
        userRepository.createUser(user);
        return user;
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }
}
