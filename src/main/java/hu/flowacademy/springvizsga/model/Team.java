package hu.flowacademy.springvizsga.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.flowacademy.springvizsga.enums.Kind;
import hu.flowacademy.springvizsga.enums.Universe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Universe universe;
    @Enumerated(EnumType.STRING)
    private Kind kind;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<SuperHero> heroes;

}
