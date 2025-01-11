package com.example.Crizbuzz.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int ranking;

    int iccPoints;

    String coach;

    int matchesPlayed;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<Player> players;

    @ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<CricketMatch> cricketMatches;

}
