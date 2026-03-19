package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullname;

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/animal")
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping("/animal")
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/animal/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animal.setId(id);
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/animal/{id}")
    public Animal deleteAnimal(@PathVariable int id) {
        return animals.remove(id);
    }
}