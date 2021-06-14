package hu.flowacademy.springvizsga.controller;

import hu.flowacademy.springvizsga.model.Team;
import hu.flowacademy.springvizsga.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/api/teams")
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @GetMapping("/api/teams/{id}")
    public Optional<Team> findOne(@PathVariable String id) {
        return teamService.findOne(id);
    }

    @PostMapping("/api/teams")
    @ResponseStatus(HttpStatus.CREATED)
    public Team save(@RequestBody Team team) {
        return teamService.save(team);
    }

    @PutMapping("/api/teams/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Team update(@RequestBody Team team, @PathVariable String id) {
        return teamService.update(id, team);
    }
}
