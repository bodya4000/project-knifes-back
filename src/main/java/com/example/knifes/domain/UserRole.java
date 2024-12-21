package com.example.knifes.domain;

import org.springframework.security.core.GrantedAuthority;

public class UserRole implements GrantedAuthority {

    private Long userId;

    private String role;

    public UserRole(Long userId, String role) {
        this.role = role;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
