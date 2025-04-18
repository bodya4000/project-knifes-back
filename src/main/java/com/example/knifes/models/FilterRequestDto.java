package com.example.knifes.models;

public record FilterRequestDto(
        MaxMinDto price,
        String manufacturer,
        String steel,
        String handle,
        String guard,
        MaxMinDto totalLength,
        MaxMinDto bladeLength,
        MaxMinDto bladeWidth,
        Integer rating
        ) {
}
