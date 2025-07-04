package com.lifetracker.lifetracker.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private UUID id;
    private String fullName;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean active;

    public User(UUID id) {
        this.id = id;
    }

    public User(String fullName, String userName, String email, String password, String phone) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
