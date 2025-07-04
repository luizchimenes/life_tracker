package com.lifetracker.lifetracker.application.usecase.user;

import com.lifetracker.lifetracker.domain.model.User;
import com.lifetracker.lifetracker.domain.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class GetUserByIdUseCase {

    private final UserRepository userRepository;

    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> execute(UUID id) {
        return userRepository.findById(id);
    }
}
