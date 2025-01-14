package com.example.knifes.services;

import com.example.knifes.dao.UserRepository;
import com.example.knifes.domain.User;
import com.example.knifes.security.JwtBuilder;
import com.example.knifes.security.JwtUtil;
import com.example.knifes.security.TokenFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final TokenFactory tokenFactory;
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
        this.tokenFactory = new TokenFactory(new JwtUtil(), new JwtBuilder(new JwtUtil()));
    }

    public List<User> getAll() {return userRepository.getAllUsers();}

    public User getById(Long id) {return userRepository.getUserById(id).orElseThrow();}

    private User save(String phoneNumber, String password) {
        var user = User.builder().phoneNumber(phoneNumber).password(password).build();
        return this.userRepository.addUser(user);
    }

    public User getByPhoneNumber(String phoneNumber) {return this.userRepository.getUserByPhoneNumber(phoneNumber).orElse(null);}

    public String authenticate(String phoneNumber, String password) {
        System.out.println("authentication..");
        var user = getByPhoneNumber(phoneNumber);
        if (user != null && user.getPassword().equals(password)) {
            return this.tokenFactory.createJwt(user);
        }
        return null;
    }

    public String create(String phoneNumber, String password) {
        System.out.println("register..");
        System.out.println(userRepository.userExistsByPhoneNumber(phoneNumber));
        if (userRepository.userExistsByPhoneNumber(phoneNumber)) return null;
        var user = this.save(phoneNumber,password);
        return this.tokenFactory.createJwt(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.getUserByPhoneNumber(username).orElseThrow();
    }
}
