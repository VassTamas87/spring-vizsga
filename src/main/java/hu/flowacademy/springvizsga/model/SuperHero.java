package hu.flowacademy.springvizsga.model;


import hu.flowacademy.springvizsga.enums.Universe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SuperHero {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Universe universe;

    @ManyToOne
    @JoinColumn
    private Team team;

    private Boolean hero;
}
