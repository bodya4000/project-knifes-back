package com.example.knifes.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {


    @GetMapping("/health")
    public ResponseEntity<String> health() throws JsonProcessingException {
        try {
            Map<String,String> responseBody = new HashMap<>();
            responseBody.put("Message", "success");
            return  ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseBody));
        } catch (JsonProcessingException e) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> ping() throws JsonProcessingException {
        try {
            Map<String,String> responseBody = new HashMap<>();
            responseBody.put("Message", "success");
            return  ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseBody));
        } catch (JsonProcessingException e) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }
}
