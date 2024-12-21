package com.example.knifes.dao;

import com.example.knifes.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(User.builder().phoneNumber("12345678").password("admin").role("admin").build());
        users.add(User.builder().phoneNumber("380997622482").password("mustafa9").role("user").build());
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public Optional<User> getUserById(long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public boolean userExistsByPhoneNumber(String phoneNumber) {
        return users.stream().anyMatch(user -> user.getUsername().equals(phoneNumber));
    }

    public Optional<User> getUserByPhoneNumber(String phoneNumber) {
        return users.stream().filter(user -> user.getUsername().equals(phoneNumber)).findFirst();
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

}
