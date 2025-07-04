package com.lifetracker.lifetracker.presentation.controller;

import com.lifetracker.lifetracker.application.usecase.user.CreateUserUseCase;
import com.lifetracker.lifetracker.application.usecase.user.GetUserByIdUseCase;
import com.lifetracker.lifetracker.domain.model.User;
import com.lifetracker.lifetracker.presentation.dto.user.UserRequestDTO;
import com.lifetracker.lifetracker.presentation.dto.user.UserResponseDTO;
import com.lifetracker.lifetracker.presentation.mapper.UserDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserByIdUseCase getUserByIdUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
        User user = UserDTOMapper.toDomain(dto);
        user = createUserUseCase.execute(user);
        return ResponseEntity.ok(UserDTOMapper.toResponse(user));
    }

    @GetMapping
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
        return getUserByIdUseCase.execute(id).map(UserDTOMapper::toResponse).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
