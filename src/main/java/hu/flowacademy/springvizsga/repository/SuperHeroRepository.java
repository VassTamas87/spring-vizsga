package hu.flowacademy.springvizsga.repository;

import hu.flowacademy.springvizsga.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, String> {
}
