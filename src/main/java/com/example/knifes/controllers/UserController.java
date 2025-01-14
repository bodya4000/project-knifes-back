package com.example.knifes.controllers;


import com.example.knifes.models.*;
import com.example.knifes.services.KnifeService;
import com.example.knifes.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/auth")
@CrossOrigin("*")
public class UserController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> auth(@RequestBody AuthRequest authRequest) {
        var jwt = userService.authenticate(authRequest.phoneNumber(), authRequest.password());
        if (jwt != null) {
            return ResponseEntity.ok(new DefaultResponse(HttpStatus.OK.value(), "Successful authentication", Map.of("accessToken", jwt)));
        }
        return ResponseEntity.ok(new DefaultResponse(HttpStatus.FORBIDDEN.value(), "Wrong credentials", Map.of()));
    }


    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody AuthRequest authRequest) {
        var jwt = userService.create(authRequest.phoneNumber(), authRequest.password());
        System.out.println("jwt = " + jwt);
        if (jwt != null) {
            return ResponseEntity.ok(new DefaultResponse(HttpStatus.OK.value(), "Successful register", Map.of("accessToken", jwt)));
        }
        return ResponseEntity.ok(new DefaultResponse(HttpStatus.FORBIDDEN.value(), "Wrong credentials", Map.of()));
    }

    @PostMapping("/ping")
    public ResponseEntity<Object> ping() {
        return ResponseEntity.ok(new DefaultResponse(HttpStatus.OK.value(), "Valid access token", Map.of("ping", "pong")));
    }
}
