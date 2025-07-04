package com.lifetracker.lifetracker.domain.repository;

import com.lifetracker.lifetracker.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void delete(UUID id);
}
