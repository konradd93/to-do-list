package pl.pollub.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.model.user.DTO.UserDTO;
import pl.pollub.model.user.User;
import pl.pollub.model.user.converter.UserDtoToEntityConverter;
import pl.pollub.repository.UserRepository;
import pl.pollub.service.UserService;

import java.util.List;
import java.util.logging.LoggingMXBean;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final @NonNull UserRepository userRepository;
    private final @NonNull UserDtoToEntityConverter userDtoToEntityConverter;

    @Override
    public User createUser(UserDTO userDTO) {
        return userRepository.save(userDtoToEntityConverter.convert(userDTO));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findOne(userId);
    }
}
