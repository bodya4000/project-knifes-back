package com.example.knifes;

public record KnifeDetailDto(
        int id,
        String imageUrl,
        String name,
        String size,
        String material,
        double rating,
        int questioners,
        double price,
        String category,
        String knifeWorkshop,
        String sharpeningAndPolishing,
        String buttCap
) {

}
