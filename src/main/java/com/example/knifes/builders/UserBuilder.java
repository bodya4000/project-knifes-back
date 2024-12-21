package com.example.knifes.builders;

import com.example.knifes.domain.User;

public class UserBuilder {
    private String phoneNumber;
    private String password;
    private String role;

    public UserBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder role(String role) {
        this.role = role;
        return this;
    }


    public User build() {
        if (this.role != null) {
            return new User(this.phoneNumber, this.password, this.role);
        }
        return new User(this.phoneNumber, this.password);
    }

}
