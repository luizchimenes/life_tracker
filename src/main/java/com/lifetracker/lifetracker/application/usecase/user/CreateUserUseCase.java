package com.lifetracker.lifetracker.application.usecase.user;

import com.lifetracker.lifetracker.domain.model.User;
import com.lifetracker.lifetracker.domain.repository.UserRepository;

public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.save(user);
    }
}
