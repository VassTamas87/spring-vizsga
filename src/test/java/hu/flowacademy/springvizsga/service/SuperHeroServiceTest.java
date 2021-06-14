package hu.flowacademy.springvizsga.service;

import hu.flowacademy.springvizsga.enums.Kind;
import hu.flowacademy.springvizsga.enums.Universe;
import hu.flowacademy.springvizsga.exception.ValidateException;
import hu.flowacademy.springvizsga.model.SuperHero;
import hu.flowacademy.springvizsga.model.Team;
import hu.flowacademy.springvizsga.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SuperHeroServiceTest {

    @Autowired
    TeamRepository teamRepository;

    @InjectMocks
    private SuperHeroService superHeroService;

    Team team1 = teamRepository.save(Team.builder().name("valami1").universe(Universe.MARVEL).kind(Kind.HERO).build());
    Team team2 = teamRepository.save(Team.builder().name("valami2").universe(Universe.DC).kind(Kind.VILLAIN).build());

    @Test
    public void testSaveValidateFailing() {
        assertThrows(ValidateException.class,
                () -> superHeroService.save(
                        giveSuperHeroWithoutKind()));

        assertThrows(ValidateException.class,
                () -> superHeroService.save(
                        giveSuperHeroWithoutName()));
        assertThrows(ValidateException.class,
                () -> superHeroService.save(
                        giveSuperheroWithoutUniverse()));
    }

    private SuperHero giveSuperHeroWithoutName() {
        return SuperHero.builder().universe(Universe.MARVEL).team(team2).hero(false).build();
    }

    private SuperHero giveSuperheroWithoutUniverse() {
        return SuperHero.builder().name("akarmi").kind(Kind.HERO)
                .build();
    }
// háát ez nem lett kész :(

}






