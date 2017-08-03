package pl.pollub.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.model.user.DTO.UserDTO;
import pl.pollub.model.user.User;
import pl.pollub.model.user.converter.UserDtoToEntityConverter;
import pl.pollub.repository.UserRepository;

import java.util.List;

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
}
