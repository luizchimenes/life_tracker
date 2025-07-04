package com.lifetracker.lifetracker.infrastructure.persistence.implementation;

import com.lifetracker.lifetracker.domain.model.User;
import com.lifetracker.lifetracker.domain.repository.UserRepository;
import com.lifetracker.lifetracker.infrastructure.persistence.entity.UserEntity;
import com.lifetracker.lifetracker.infrastructure.persistence.mapper.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    private final SpringUserRepository jpa;

    public UserRepositoryImpl(SpringUserRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        return UserMapper.toDomain(jpa.save(entity));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpa.findById(id).map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpa.findByEmail(email).map(UserMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpa.findAll().stream()
                .map(UserMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(UUID id) {
        jpa.deleteById(id);
    }


}
