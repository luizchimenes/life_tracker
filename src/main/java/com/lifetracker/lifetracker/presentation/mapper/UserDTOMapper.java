package com.lifetracker.lifetracker.presentation.mapper;

import com.lifetracker.lifetracker.domain.model.User;
import com.lifetracker.lifetracker.presentation.dto.user.UserRequestDTO;
import com.lifetracker.lifetracker.presentation.dto.user.UserResponseDTO;

public class UserDTOMapper {

    public static User toDomain(UserRequestDTO dto) {
        return new User(
                dto.fullName,
                dto.username,
                dto.email,
                dto.password,
                dto.phone
        );
    }

    public static UserResponseDTO toResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.id = user.getId();
        dto.fullName = user.getFullName();
        dto.email = user.getEmail();
        dto.phone = user.getPhone();
        return dto;
    }


}
