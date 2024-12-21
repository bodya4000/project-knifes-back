package com.example.knifes.models;


public record KnifeDto(
        int id,
        String imageUrl,
        String name,
        String size,
        String material,
        double rating,
        int questioners,
        double price

) {
}
