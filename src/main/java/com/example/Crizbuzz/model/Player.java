package com.example.Crizbuzz.model;

import com.example.Crizbuzz.model.Enum.Gender;
import com.example.Crizbuzz.model.Enum.Speciality;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    String email;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    Stats stats;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    Team team;

}
