package hu.flowacademy.springvizsga.service;

import hu.flowacademy.springvizsga.enums.Kind;
import hu.flowacademy.springvizsga.exception.ValidateException;
import hu.flowacademy.springvizsga.model.SuperHero;
import hu.flowacademy.springvizsga.model.Team;
import hu.flowacademy.springvizsga.repository.SuperHeroRepository;
import hu.flowacademy.springvizsga.repository.TeamRepository;
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
    private final TeamRepository teamRepository;

    public List<SuperHero> findAll() {
        return superHeroRepository.findAll();
    }

    public Optional<SuperHero> findOne(String id) {
        return superHeroRepository.findById(id);
    }

    public SuperHero save(SuperHero superHero) {
        validate(superHero);
        return superHeroRepository.save(superHero);
    }

    public SuperHero update(String id, SuperHero superHero) {
        validate(superHero);
        return superHeroRepository.save(superHero.toBuilder().id(id).build());
    }

    public void validate(SuperHero superHero) {
        Team team = teamRepository.findById(superHero.getTeam().getId()).orElseThrow();

        if (superHero.getName() == null) {
            throw new ValidateException("Nem adtál meg nevet!!!");
        }
        if (superHero.getName().equals("")) {
            throw new ValidateException("Nem adtál meg nevet!!!");
        }
        if (superHero.getUniverse() == null) {
            throw new ValidateException("Hiányzik a Universe!!!!");
        }
        if (!teamRepository.existsById(superHero.getTeam().getId())) {
            throw new ValidateException("Nincs ilyen team!!!!");
        }
        if (!superHero.getUniverse().equals(team.getUniverse())) {
            throw new ValidateException("Nem egyezik a universe!!!");
        }
        if (superHero.getHero() && team.getKind().equals(Kind.VILLAIN)) {
            throw new ValidateException("Nem lehet hero!!!");
        }
        if (!superHero.getHero() && team.getKind().equals(Kind.HERO)) {
            throw new ValidateException("Nem lehet villain!!!");
        }
    }
}
