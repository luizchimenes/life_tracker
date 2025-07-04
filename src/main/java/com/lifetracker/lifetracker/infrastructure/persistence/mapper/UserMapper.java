package com.lifetracker.lifetracker.infrastructure.persistence.mapper;

import com.lifetracker.lifetracker.domain.model.User;
import com.lifetracker.lifetracker.infrastructure.persistence.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deletedAt(user.getDeletedAt())
                .active(user.isActive())
                .build();
    }

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getFullName(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getPhone(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt(),
                entity.isActive()
        );
    }
}
