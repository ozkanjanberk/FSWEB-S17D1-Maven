package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullName;

    public AnimalController() {
        this.animals = new HashMap<>();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.get(id);
    }

    @GetMapping
    public List<Animal> getAnimals(){
        return new ArrayList<>(animals.values());
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal){
        this.animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        animals.put(id, updatedAnimal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animals.remove(id);
    }
}
