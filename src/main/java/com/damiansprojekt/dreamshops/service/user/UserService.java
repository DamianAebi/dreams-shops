package com.damiansprojekt.dreamshops.service.user;

import com.damiansprojekt.dreamshops.exception.AlreadyExistsException;
import com.damiansprojekt.dreamshops.exception.ResourceNotFoundException;
import com.damiansprojekt.dreamshops.model.User;
import com.damiansprojekt.dreamshops.repository.UserRepository;
import com.damiansprojekt.dreamshops.request.AddUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    }

    @Override
    public User createUser(AddUserRequest request) {
        return Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                .map(req -> {
                    User user = new User(
                            request.getFirstName(),
                            request.getLastName(),
                            request.getEmail(),
                            request.getPassword()
                    );
                    return userRepository.save(user);
                }).orElseThrow(() -> new AlreadyExistsException(request.getEmail() + " already exists!"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(userRepository::delete, () -> {
            throw new ResourceNotFoundException("User not found!");
        });
    }
}
