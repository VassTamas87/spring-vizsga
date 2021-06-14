package hu.flowacademy.springvizsga.model;

import hu.flowacademy.springvizsga.enums.Kind;
import hu.flowacademy.springvizsga.enums.Universe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Universe universe;
    @Enumerated(EnumType.STRING)
    private Kind kind;
}
