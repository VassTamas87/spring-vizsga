package hu.flowacademy.springvizsga.service;

import hu.flowacademy.springvizsga.model.SuperHero;
import hu.flowacademy.springvizsga.repository.SuperHeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SuperHeroService {

    private final SuperHeroRepository superHeroRepository;

    public List<SuperHero> findAll() {
        return superHeroRepository.findAll();
    }

    public Optional<SuperHero> findOne(String id) {
        return superHeroRepository.findById(id);
    }

    public SuperHero save(SuperHero superHero) {
        return superHeroRepository.save(superHero);
    }

    public SuperHero update(String id, SuperHero superHero) {
        return superHeroRepository.save(superHero.toBuilder().id(id).build());
    }
}
