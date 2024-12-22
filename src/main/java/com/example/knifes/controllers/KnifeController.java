package com.example.knifes.controllers;


import com.example.knifes.models.FilterRequestDto;
import com.example.knifes.models.KnifeDetailDto;
import com.example.knifes.models.KnifeDto;
import com.example.knifes.services.KnifeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class KnifeController {

    @PostMapping("/knives")
    public Map<String, Object> getKnives(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size,
        @RequestParam(required = false,  defaultValue = "questioners", name = "sort") String sortMode,
        @RequestBody FilterRequestDto filterRequestDto
    ) {
        System.out.println(filterRequestDto);
        List<KnifeDto> allKnives = KnifeService.getAllKnives(filterRequestDto, sortMode);
        int totalKnives = allKnives.size();
        int totalPages = (int) Math.ceil((double) totalKnives / size);

        int start = Math.min(page * size, totalKnives);
        int end = Math.min(start + size, totalKnives);
        List<KnifeDto> knivesPage = allKnives.subList(start, end);

        Map<String, Object> response = new HashMap<>();
        response.put("totalPages", totalPages);
        response.put("knives", knivesPage);
        return response;
    }

    @GetMapping("/knives/{id}")
    public KnifeDetailDto getKnives(
            @PathVariable("id") int id
    ) {
        return KnifeService.getKnifeDtoById(id);
    }

    @GetMapping("/options")
    @Cacheable
    public Map<String, Object> getOptions(
    ) {
        return KnifeService.loadOptions();
    }
}
