package com.example.Crizbuzz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int runs;

    int wickets;

    double battingAverage;

    double bowlingAverage;

    @OneToOne
    @JoinColumn
    @JsonBackReference
    Player player;

}
