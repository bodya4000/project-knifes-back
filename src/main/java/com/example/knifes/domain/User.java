package com.example.knifes.domain;


import com.example.knifes.builders.UserBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User implements UserDetails {

    private static AtomicInteger idCounter = new AtomicInteger();

    private Long id;

    private String phoneNumber;

    private String password;

    private List<UserRole> roles = new ArrayList<>();

    public User(String phoneNumber, String password) {
        this.id = (long) idCounter.incrementAndGet();
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(String phoneNumber, String password, String role) {
        this.id = (long) idCounter.incrementAndGet();
        this.phoneNumber = phoneNumber;
        this.password = password;

        var userRole = new UserRole((long)idCounter.get(), role);
        roles.add(userRole);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public Long getId() {
        return id;
    }
}
