package hu.flowacademy.springvizsga.service;

import hu.flowacademy.springvizsga.enums.Kind;
import hu.flowacademy.springvizsga.enums.Universe;
import hu.flowacademy.springvizsga.exception.ValidateException;
import hu.flowacademy.springvizsga.model.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Test
    public void testSaveValidateFailing() {
        assertThrows(ValidateException.class,
                () -> teamService.save(
                        giveTeamWithoutKind()));

        assertThrows(ValidateException.class,
                () -> teamService.save(
                        giveTeamWithoutName()));
        assertThrows(ValidateException.class,
                () -> teamService.save(
                        giveTeamWithoutUniverse()));
    }

    private Team giveTeamWithoutName() {
        return Team.builder().universe(Universe.MARVEL).kind(Kind.HERO)
                .build();
    }

    private Team giveTeamWithoutUniverse() {
        return Team.builder().name("akarmi").kind(Kind.HERO)
                .build();
    }

    private Team giveTeamWithoutKind() {
        return Team.builder().name("valami").universe(Universe.MARVEL).build();
    }
}