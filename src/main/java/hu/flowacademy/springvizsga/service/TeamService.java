package hu.flowacademy.springvizsga.service;

import hu.flowacademy.springvizsga.model.Team;
import hu.flowacademy.springvizsga.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;


    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> findOne(String id) {
        return teamRepository.findById(id);
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team update(String id, Team team) {
        return teamRepository.save(team.toBuilder().id(id).build());
    }
}
