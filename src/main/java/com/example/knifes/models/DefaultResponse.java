package com.example.knifes.models;

import java.util.Map;

public record DefaultResponse (
        Integer status,
        String message,
        Map<String, String> body
) { }
