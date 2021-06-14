package hu.flowacademy.springvizsga.controller;

import hu.flowacademy.springvizsga.model.SuperHero;
import hu.flowacademy.springvizsga.service.SuperHeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    @GetMapping("/api/super-hero")
    public List<SuperHero> findAll() {
        return superHeroService.findAll();
    }

    @GetMapping("/api/super-hero/{id}")
    public Optional<SuperHero> findOne(@PathVariable String id) {
        return superHeroService.findOne(id);
    }

    @PostMapping("/api/super-hero")
    @ResponseStatus(HttpStatus.CREATED)
    public SuperHero save(@RequestBody SuperHero superHero) {
        return superHeroService.save(superHero);
    }

    @PutMapping("/api/super-hero/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SuperHero update(@RequestBody SuperHero superHero, @PathVariable String id) {
        return superHeroService.update(id, superHero);
    }
}
